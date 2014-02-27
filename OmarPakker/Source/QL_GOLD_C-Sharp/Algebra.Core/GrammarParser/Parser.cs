using System;
using System.Collections.ObjectModel;
using System.IO;
using GOLD;

namespace Algebra.Core.GrammarParser
{
    public abstract class Parser : IParser
    {
        public event Action<int, int, object> OnReduction;
        public event Action<object> OnCompletion;
        public event Action OnGroupError;
        public event Action OnInternalError;
        public event Action OnNotLoadedError;
        public event Action<int, int, object> OnLexicalError;
        public event Action<int, int, object, string> OnSyntaxError;

        private GOLD.Parser parser;

        protected abstract ReadOnlyDictionary<string, short> Rules { get; }

        public Parser(bool trimReductions)
        {
            parser = new GOLD.Parser();
            parser.TrimReductions = trimReductions;
        }

        public bool LoadGrammar(string grammarFilePath)
        {
            return parser.LoadTables(grammarFilePath);
        }

        public bool LoadGrammar(BinaryReader reader)
        {
            return parser.LoadTables(reader);
        }

        public bool Parse(string text)
        {
            parser.Open(ref text);

            return DoParse();
        }

        public bool Parse(TextReader reader)
        {
            parser.Open(reader);

            return DoParse();
        }

        private bool DoParse()
        {
            while (true)
            {
                switch (parser.Parse())
                {
                    case ParseMessage.TokenRead:
                        break;

                    case ParseMessage.Reduction:
                        //Create a custom object and store the reduction
                        Reduction r = parser.CurrentReduction as Reduction;
                        object newObj = CreateObjectFor(r);
                        parser.CurrentReduction = newObj;

                        if (OnReduction != null)
                        {
                            Position pos = parser.CurrentPosition();
                            OnReduction(pos.Line, pos.Column, newObj);
                        }
                        break;

                    case ParseMessage.Accept:
                        //All good!
                        if (OnCompletion != null)
                        {
                            OnCompletion(parser.CurrentReduction);
                        }
                        return true;

                    case ParseMessage.GroupError:
                        //Unexpected end of file (EOF)
                        if (OnGroupError != null)
                        {
                            OnGroupError();
                        }
                        OnGroupError();
                        return false;

                    case ParseMessage.InternalError:
                        //Something went wrong internally
                        if (OnInternalError != null)
                        {
                            OnInternalError();
                        }
                        OnInternalError();
                        return false;

                    case ParseMessage.LexicalError:
                        //Token not recognized
                        if (OnLexicalError != null)
                        {
                            OnLexicalError(parser.CurrentPosition().Line, parser.CurrentPosition().Column, parser.CurrentToken().Data);
                        }
                        return false;

                    case ParseMessage.NotLoadedError:
                        //CGT wasn't loaded
                        if (OnNotLoadedError != null)
                        {
                            OnNotLoadedError();
                        }
                        return false;

                    case ParseMessage.SyntaxError:
                        //Expected a different token
                        if (OnSyntaxError != null)
                        {
                            OnSyntaxError(parser.CurrentPosition().Line, parser.CurrentPosition().Column,
                                parser.CurrentToken().Data, parser.ExpectedSymbols().Text());
                        }
                        return false;
                }
            }
        }

        protected abstract object CreateObjectFor(Reduction r);
    }
}
