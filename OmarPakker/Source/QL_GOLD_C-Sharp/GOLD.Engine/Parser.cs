using System;
using System.Collections.Generic;
using System.IO;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Parser
    {
        public event Action<Token> OnTokenRead;
        public event Action<Tuple<int, int>, Tuple<int, int>, Reduction> OnReduction;
        public event Action<object> OnCompletion;
        public event Action OnGroupError;
        public event Action OnInternalError;
        public event Action OnNotLoadedError;
        public event Action<Tuple<int, int>, string> OnLexicalError;
        public event Action<Tuple<int, int>, string, string> OnSyntaxError;


        public bool TrimReductions { get; set; }
        public bool TablesLoaded { get; private set; }
        public GrammarProperties GrammarProperties { get; private set; }
        public SymbolList ExpectedSymbols { get; private set; }
        public Tuple<int, int> CurrentPosition { get { return lookAheadBuffer.Position; } }

        private LookAheadBuffer lookAheadBuffer;
        private GrammarTables grammarTables;

        private Stack<Token> tokenStack;
        private Stack<Token> groupStack;

        public Parser()
        {
            TrimReductions = false;
            TablesLoaded = false;

            ExpectedSymbols = new SymbolList();

            tokenStack = new Stack<Token>();
            groupStack = new Stack<Token>();
        }

        private void InitializeForParsing(TextReader reader)
        {
            lookAheadBuffer = new LookAheadBuffer(reader);
            ExpectedSymbols.Clear();
            tokenStack.Clear();
            groupStack.Clear();
        }

        private void Reset()
        {
            TablesLoaded = false;
            lookAheadBuffer = null;
            GrammarProperties = null;
            ExpectedSymbols.Clear();
            grammarTables.Clear();
            tokenStack.Clear();
            groupStack.Clear();
        }

        public bool Open(ref string textInput)
        {
            return Open(new StringReader(textInput));
        }

        public bool Open(TextReader reader)
        {
            InitializeForParsing(reader);

            tokenStack.Push(new Token());

            return true;
        }

        public bool LoadEGT(BinaryReader reader)
        {
            if(TablesLoaded)
            {
                Reset();
            }

            using (EGTReader egtReader = new EGTReader(reader))
            {
                while (egtReader.GetNextRecord())
                {
                    switch (egtReader.ReadRecordType())
                    {
                        case EGTRecord.Property:
                            GrammarProperties = new GrammarProperties();
                            GrammarProperties.SetProperty(egtReader.ReadGrammarProperty());
                            break;

                        case EGTRecord.TableCounts:
                            grammarTables = egtReader.ReadGrammarTables();
                            break;

                        case EGTRecord.InitialStates:
                            //DFA, LALR
                            ushort dfaState = egtReader.ReadUInt16();
                            ushort lalrState = egtReader.ReadUInt16();
                            if (dfaState != 0 || lalrState != 0)
                            {
                                throw new ParserException(String.Format("The DFA and/or LALR state is not 0; DFA({0}), LALR({1})", dfaState, lalrState));
                            }
                            break;

                        case EGTRecord.Symbol:
                            Symbol sym = egtReader.ReadSymbol();
                            grammarTables.Symbols[sym.TableIndex] = sym;
                            break;

                        case EGTRecord.Group:
                            Group group = egtReader.ReadGroup();
                            grammarTables.Groups[group.TableIndex] = group;
                            break;

                        case EGTRecord.CharRanges:
                            CharacterSet charSet = egtReader.ReadCharacterSet();
                            grammarTables.CharacterSets[charSet.Index] = charSet;
                            break;

                        case EGTRecord.Production:
                            Production prod = egtReader.ReadProduction();
                            grammarTables.Productions[prod.TableIndex] = prod;
                            break;

                        case EGTRecord.DFAState:
                            FAState faState = egtReader.ReadFAState();
                            grammarTables.FAStates[faState.TableIndex] = faState;
                            break;

                        case EGTRecord.LRState:
                            LRActionList actionList = egtReader.ReadLRActionList();
                            grammarTables.LRActionLists[actionList.Index] = actionList;
                            break;
                    }
                }
            }

            TablesLoaded = true;
            return true;
        }

        //This function implements the DFA for th parser's lexer.
        //It generates a token which is used by the LALR state
        //machine.
        private Token LookAheadDFA()
        {
            string ch = lookAheadBuffer.LookAhead(1);

            if (String.IsNullOrEmpty(ch) || ch[0] == Char.MaxValue)
            {
                return new Token(grammarTables.Symbols.GetFirstOfType(SymbolType.End), String.Empty)
                {
                    Position = CurrentPosition
                };
            }

            int currentDFA = 0;
            int lookAheadPosition = 1;
            //Next byte in the input Stream
            int lastAcceptState = -1;
            //We have not yet accepted a character string
            int lastAcceptPosition = -1;

            while (true)
            {
                bool found = false;
                ch = lookAheadBuffer.LookAhead(lookAheadPosition);

                if (!String.IsNullOrEmpty(ch))
                {
                    for (int i = 0; i < grammarTables.FAStates[currentDFA].Edges.Count; i++)
                    {
                        FAEdge Edge = grammarTables.FAStates[currentDFA].Edges[i];

                        //Look for character in the Character Set Table
                        if (Edge.Characters.Contains(ch[0]))
                        {
                            int target = Edge.Target;

                            if (grammarTables.FAStates[target].Accept != null)
                            {
                                lastAcceptState = target;
                                lastAcceptPosition = lookAheadPosition;
                            }

                            currentDFA = target;
                            lookAheadPosition++;

                            found = true;
                            break;
                        }
                    }
                }

                if (!found)
                {
                    // Lexer cannot recognize symbol
                    if (lastAcceptState == -1)
                    {
                        // Create Token, read characters
                        return new Token(grammarTables.Symbols.GetFirstOfType(SymbolType.Error), lookAheadBuffer.GetTextFromBuffer(1))
                        {
                            Position = CurrentPosition
                        };
                    }
                    else
                    {
                        //Data contains the total number of accept characters
                        return new Token(grammarTables.FAStates[lastAcceptState].Accept, lookAheadBuffer.GetTextFromBuffer(lastAcceptPosition))
                        {
                            Position = CurrentPosition
                        };
                    }
                }
            }
        }

        private Token ProduceToken()
        {
            while (true)
            {
                Token read = LookAheadDFA();

                if (read.Type == SymbolType.GroupStart && (groupStack.Count == 0 || groupStack.Peek().Group.Nesting.Contains(read.Group.TableIndex)))
                {
                    lookAheadBuffer.Consume(read.Data.Length);
                    groupStack.Push(read);
                }
                else if (groupStack.Count == 0)
                {
                    //The token is ready to be analyzed.             
                    lookAheadBuffer.Consume(read.Data.Length);
                    return read;
                }
                else if (Object.ReferenceEquals(groupStack.Peek().Group.End, read.Symbol))
                {
                    //End the current group
                    Token pop = groupStack.Pop();

                    //=== Ending logic
                    if (pop.Group.Ending == GroupEndingMode.Closed)
                    {
                        pop.Data += read.Data;
                        //Append text
                        lookAheadBuffer.Consume(read.Data.Length);
                        //Consume token
                    }

                    //We are out of the group. Return pop'd token (which contains all the group text)
                    if (groupStack.Count == 0)
                    {
                        pop.Symbol = pop.Group.Container;
                        //Change symbol to parent
                        return pop;
                    }
                    else
                    {
                        groupStack.Peek().Data += pop.Data;
                        //Append group text to parent
                    }

                }
                else if (read.Type == SymbolType.End)
                {
                    //EOF always stops the loop. The caller function (Parse) can flag a runaway group error.
                    return read;
                }
                else
                {
                    //We are in a group, Append to the Token on the top of the stack.
                    //Take into account the Token group mode  
                    Token top = groupStack.Peek();

                    if (top.Group.Advance == GroupAdvanceMode.Token)
                    {
                        // Append all text
                        top.Data += read.Data;
                        lookAheadBuffer.Consume(read.Data.Length);
                    }
                    else
                    {
                        // Append one character
                        top.Data += read.Data[0].ToString();
                        lookAheadBuffer.Consume(1);
                    }
                }
            }
        }

        //This function analyzes a token and either:
        //  1. Makes a SINGLE reduction and pushes a complete Reduction object on the m_Stack
        //  2. Accepts the token and shifts
        //  3. Errors and places the expected symbol indexes in the Tokens list
        //The Token is assumed to be valid and WILL be checked
        //If an action is performed that requires controlt to be returned to the user, the function returns true.
        //The Message parameter is then set to the type of action.
        private ParseResult ParseLALR(Token nextToken, ref ushort currentLALRState)
        {
            LRAction parseAction = grammarTables.LRActionLists[currentLALRState][nextToken.Symbol];

            if (parseAction == null)
            {
                ExpectedSymbols.Clear();
                for (int i = 0; i < grammarTables.LRActionLists[currentLALRState].Count; i++)
                {
                    Symbol actionSymbol = grammarTables.LRActionLists[currentLALRState][i].Symbol;
                    switch (actionSymbol.Type)
                    {
                        case SymbolType.Content:
                        case SymbolType.End:
                        case SymbolType.GroupStart:
                        case SymbolType.GroupEnd:
                            ExpectedSymbols.Add(actionSymbol);
                            break;
                    }
                }
                return ParseResult.SyntaxError;
            }

            // Work - shift or reduce
            switch (parseAction.Type)
            {
                case LRActionType.Accept:
                    return ParseResult.Accept;

                case LRActionType.Shift:
                    currentLALRState = parseAction.Value;
                    nextToken.State = currentLALRState;
                    tokenStack.Push(nextToken);
                    return ParseResult.Shift;

                case LRActionType.Reduce:
                    Token head = null;
                    //Produce a reduction - remove as many tokens as members in the rule & push a nonterminal token
                    Production prod = grammarTables.Productions[parseAction.Value];
                    ParseResult result;

                    //Create Reduction
                    if (TrimReductions && prod.ContainsOneNonTerminal())
                    {
                        head = tokenStack.Pop();
                        head.Symbol = prod.Head;

                        result = ParseResult.ReduceEliminated;
                    }
                    //Build a Reduction
                    else
                    {
                        Reduction reduction = new Reduction(prod.Handle.Count, prod.Head);
                        reduction.Production = prod;

                        for (int i = prod.Handle.Count - 1; i >= 0; i--)
                        {
                            reduction[i] = tokenStack.Pop();
                        }

                        //head = new Token(prod.Head, NewReduction);
                        head = reduction;
                        result = ParseResult.ReduceNormal;
                    }

                    ushort nextActionIndex = tokenStack.Peek().State;

                    //If n is -1 here, then we have an Internal Table Error!!!
                    int n = grammarTables.LRActionLists[nextActionIndex].IndexOf(prod.Head);
                    if (n == -1)
                    {
                        return ParseResult.InternalError;
                    }

                    currentLALRState = grammarTables.LRActionLists[nextActionIndex][n].Value;

                    head.State = currentLALRState;
                    tokenStack.Push(head);

                    return result;
            }

            return ParseResult.Accept;
        }

        public bool Parse()
        {
            if(!TablesLoaded)
            {
                if(OnNotLoadedError != null)
                {
                    OnNotLoadedError();
                }
                return false;
            }

            TokenQueueStack inputTokens = new TokenQueueStack();
            ushort lalrState = 0;

            while (true)
            {
                if (inputTokens.Count == 0)
                {
                    inputTokens.Push(ProduceToken());
                    if(OnTokenRead != null)
                    {
                        OnTokenRead(inputTokens.Peek());
                    }
                }
                //Runaway group
                else if (groupStack.Count != 0)
                {
                    if(OnGroupError != null)
                    {
                        OnGroupError();
                    }
                    return false; //Error; abort
                }
                else
                {
                    Token read = inputTokens.Peek();

                    switch (read.Type)
                    {
                        case SymbolType.Noise:
                            inputTokens.Pop();
                            break;

                        case SymbolType.Error:
                            if(OnLexicalError != null)
                            {
                                OnLexicalError(read.Position, read.Data);
                            }
                            return false; //Error; abort

                        default:
                            switch (ParseLALR(read, ref lalrState))
                            {
                                case ParseResult.Accept:
                                    if (OnCompletion != null)
                                    {
                                        OnCompletion(tokenStack.Peek().Tag);
                                    }
                                    return true; //Done

                                case ParseResult.InternalError:
                                    if (OnInternalError != null)
                                    {
                                        OnInternalError();
                                    }
                                    return false; //Error; abort

                                case ParseResult.ReduceNormal:
                                    if (OnReduction != null)
                                    {
                                        OnReduction(read.Position, lookAheadBuffer.Position, (Reduction)tokenStack.Peek());
                                    }
                                    break;

                                case ParseResult.Shift:
                                    //ParseToken() shifted the token on the front of the Token-Queue. 
                                    //It now exists on the Token-Stack and must be eliminated from the queue.
                                    inputTokens.Dequeue();
                                    break;

                                case ParseResult.SyntaxError:
                                    if (OnSyntaxError != null)
                                    {
                                        OnSyntaxError(read.Position, read.Data, ExpectedSymbols.ToString());
                                    }
                                    return false; //Error; abort
                            }
                            break;
                    }
                }
            }
        }
    }
}
