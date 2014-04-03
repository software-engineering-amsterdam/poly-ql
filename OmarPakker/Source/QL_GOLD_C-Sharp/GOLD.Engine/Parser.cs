using System;
using System.Collections.Generic;
using System.IO;
using GOLD.Engine.EGT;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Parser
    {
        public event Action<Token> TokenRead;
        public event Action<Reduction> Reduction;
        public event Action<object> Completed;
        public event Action GroupError;
        public event Action InternalError;
        public event Action NotLoadedError;
        public event Action<Tuple<int, int>, string> LexicalError;
        public event Action<Tuple<int, int>, string, string> SyntaxError;

        public bool TrimReductions { get; set; }
        public bool SkipEmptyProductions { get; set; }
        private EGTDataManager egtDataManager;

        public Parser()
        {
            TrimReductions = false;
            SkipEmptyProductions = false;
        }

        protected virtual void OnTokenRead(Token token)
        {
            if (TokenRead != null)
            {
                TokenRead(token);
            }
        }

        protected virtual void OnReduction(Reduction reduction)
        {
            if (Reduction != null)
            {
                Reduction(reduction);
            }
        }

        protected virtual void OnCompleted(object obj)
        {
            if (Completed != null)
            {
                Completed(obj);
            }
        }

        protected virtual void OnGroupError()
        {
            if (GroupError != null)
            {
                GroupError();
            }
        }

        protected virtual void OnInternalError()
        {
            if (InternalError != null)
            {
                InternalError();
            }
        }

        protected virtual void OnNotLoadedError()
        {
            if (NotLoadedError != null)
            {
                NotLoadedError();
            }
        }

        protected virtual void OnLexicalError(Tuple<int, int> position, string symbol)
        {
            if (LexicalError != null)
            {
                LexicalError(position, symbol);
            }
        }

        protected virtual void OnSyntaxError(Tuple<int, int> position, string symbol, string expected)
        {
            if (SyntaxError != null)
            {
                SyntaxError(position, symbol, expected);
            }
        }

        public bool LoadEGT(BinaryReader reader)
        {
            egtDataManager = new EGTDataManager(reader);

            return true;
        }

        //This function implements the DFA for th parser's lexer.
        //It generates a token which is used by the LALR state
        //machine.
        private Token LookAheadDFA(LookAheadBuffer lookAheadBuffer)
        {
            string ch = lookAheadBuffer.LookAhead(1);

            if (String.IsNullOrEmpty(ch) || ch[0] == Char.MaxValue)
            {
                return new Token(egtDataManager.GetFirstSymbolOfType(SymbolType.End), String.Empty)
                {
                    StartPosition = lookAheadBuffer.Position,
                    EndPosition = lookAheadBuffer.Position
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
                    foreach (FAEdge edge in egtDataManager.GetFAState(currentDFA).Edges)
                    {
                        //Look for character in the Character Set Table
                        if (edge.Characters.Contains(ch[0]))
                        {
                            int target = edge.Target;

                            if (egtDataManager.GetFAState(target).Accept != null)
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
                    Symbol symbol = null;
                    string data = String.Empty;

                    // Lexer cannot recognize symbol
                    if (lastAcceptState == -1)
                    {
                        symbol = egtDataManager.GetFirstSymbolOfType(SymbolType.Error);
                        data = lookAheadBuffer.GetTextFromBuffer(1);
                    }
                    else
                    {
                        symbol = egtDataManager.GetFAState(lastAcceptState).Accept;
                        data = lookAheadBuffer.GetTextFromBuffer(lastAcceptPosition);
                    }

                    return new Token(symbol, data)
                    {
                        StartPosition = lookAheadBuffer.Position
                    };
                }
            }
        }

        private Token ProduceToken(Stack<Token> groupStack, LookAheadBuffer lookAheadBuffer)
        {
            while (true)
            {
                Token read = LookAheadDFA(lookAheadBuffer);

                if (read.Type == SymbolType.GroupStart && (groupStack.Count == 0 || groupStack.Peek().Group.Nesting.Contains(read.Group.TableIndex)))
                {
                    lookAheadBuffer.Consume(read.Data.Length);
                    read.EndPosition = lookAheadBuffer.Position;
                    groupStack.Push(read);
                }
                else if (groupStack.Count == 0)
                {
                    //The token is ready to be analyzed.             
                    lookAheadBuffer.Consume(read.Data.Length);
                    read.EndPosition = lookAheadBuffer.Position;
                    return read;
                }
                else if (Object.ReferenceEquals(groupStack.Peek().Group.End, read.Symbol))
                {
                    //End the current group
                    Token pop = groupStack.Pop();

                    if (pop.Group.Ending == GroupEndingMode.Closed)
                    {
                        pop.Data += read.Data;
                        lookAheadBuffer.Consume(read.Data.Length);
                        read.EndPosition = lookAheadBuffer.Position;
                    }

                    //We are out of the group. Return pop'd token (which contains all the group text)
                    if (groupStack.Count == 0)
                    {
                        //Change symbol to parent
                        pop.Symbol = pop.Group.Container;
                        return pop;
                    }
                    else
                    {
                        groupStack.Peek().Data += pop.Data;
                    }
                }
                else if (read.Type == SymbolType.End)
                {
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

                    read.EndPosition = lookAheadBuffer.Position;
                }
            }
        }

        public bool Parse(ref string input)
        {
            return Parse(new StringReader(input));
        }

        public bool Parse(TextReader reader)
        {
            if (egtDataManager == null)
            {
                OnNotLoadedError();
                return false;
            }

            TokenQueueStack inputTokens = new TokenQueueStack();
            Stack<Token> tokenStack = new Stack<Token>();
            tokenStack.Push(new Token());
            Stack<Token> groupStack = new Stack<Token>();
            LookAheadBuffer lookAheadBuffer = new LookAheadBuffer(reader);
            ushort lalrState = 0;

            while (true)
            {
                if (inputTokens.Count == 0)
                {
                    inputTokens.Push(ProduceToken(groupStack, lookAheadBuffer));
                    OnTokenRead(inputTokens.Peek());
                }
                //Runaway group
                else if (groupStack.Count != 0)
                {
                    OnGroupError();
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
                            OnLexicalError(read.EndPosition, read.Data);
                            return false; //Error; abort

                        default:
                            LRActionList actionList = egtDataManager.GetLRActionList(lalrState);
                            LRAction parseAction = actionList[read.Symbol];
                            if (parseAction == null)
                            {
                                HandleSyntaxError(actionList, read);
                                return false;
                            }

                            switch (parseAction.Type)
                            {
                                case LRActionType.Accept:
                                    OnCompleted(tokenStack.Peek().Tag);
                                    return true;

                                case LRActionType.Shift:
                                    lalrState = parseAction.Value;
                                    read.State = lalrState;
                                    tokenStack.Push(read);
                                    //It now exists on the Token-Stack and must be eliminated from the queue.
                                    inputTokens.Dequeue();
                                    break;

                                case LRActionType.Reduce:
                                    if (!DoReduction(tokenStack, lookAheadBuffer, ref lalrState, parseAction))
                                    {
                                        return false;
                                    }
                                    break;
                            }
                            break;
                    }
                }
            }
        }

        private bool DoReduction(Stack<Token> tokenStack, LookAheadBuffer lookAheadBuffer, ref ushort lalrState, LRAction parseAction)
        {
            Token head = null;
            //Produce a reduction - remove as many tokens as members in the rule & push a nonterminal token
            Production prod = egtDataManager.GetProduction(parseAction.Value);
            bool reductionSkipped = false;

            //Skip reduction?
            if ((TrimReductions && prod.ConsistsOfOneNonTerminal())
                || (SkipEmptyProductions && prod.Handle.Count == 0))
            {
                head = tokenStack.Pop();
                head.Symbol = prod.Head;
                reductionSkipped = true;
            }
            //Build a Reduction
            else
            {
                Reduction reduction = new Reduction(prod.Handle.Count, prod);

                //If a production has no handles, it has no location.
                //Set a would-be location instead.
                if (prod.Handle.Count == 0)
                {
                    reduction.StartPosition = reduction.EndPosition = lookAheadBuffer.Position;
                }
                else
                {
                    for (int i = prod.Handle.Count - 1; i >= 0; i--)
                    {
                        reduction[i] = tokenStack.Pop();
                    }
                }
                
                head = reduction;
            }

            //If n is -1 here, then we have an Internal Table Error!!!
            LRAction action = egtDataManager.GetLRActionList(tokenStack.Peek().State)[prod.Head];
            if (action == null)
            {
                OnInternalError();
                return false;
            }

            lalrState = action.Value;

            head.State = lalrState;
            tokenStack.Push(head);

            if (!reductionSkipped)
            {
                OnReduction((Reduction)tokenStack.Peek());
            }
            return true;
        }

        private void HandleSyntaxError(LRActionList actionList, Token read)
        {
            List<Symbol> expectedSymbols = new List<Symbol>();
            for (int i = 0; i < actionList.Count; i++)
            {
                Symbol actionSymbol = actionList[i];
                switch (actionSymbol.Type)
                {
                    case SymbolType.Content:
                    case SymbolType.End:
                    case SymbolType.GroupStart:
                    case SymbolType.GroupEnd:
                        expectedSymbols.Add(actionSymbol);
                        break;
                }
            }

            OnSyntaxError(read.EndPosition, read.Data, String.Join(",", expectedSymbols));
        }
    }
}
