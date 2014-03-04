using System;
using System.Collections.ObjectModel;
using System.IO;
using GOLD.Engine;
using GOLD.Engine.Enums;

namespace Algebra.Core.GrammarParser
{
    public abstract class Parser : IParser
    {
        public event Action<Tuple<int, int>, Tuple<int, int>, object> OnReduction;
        public event Action<object> OnCompletion;
        public event Action OnGroupError;
        public event Action OnInternalError;
        public event Action OnNotLoadedError;
        public event Action<Tuple<int, int>, object> OnLexicalError;
        public event Action<Tuple<int, int>, object, string> OnSyntaxError;

        private GOLD.Engine.Parser parser;

        protected abstract ReadOnlyDictionary<string, short> Rules { get; }

        public Parser(bool trimReductions)
        {
            parser = new GOLD.Engine.Parser();
            parser.TrimReductions = trimReductions;

            parser.OnReduction += (start, end, obj) =>
            {
                object newObj = CreateObjectFor(obj);
                obj.Tag = newObj;

                if (OnReduction != null)
                {
                    OnReduction(start, end, newObj);
                }
            };
            parser.OnCompletion += (obj) =>
            {
                if (OnCompletion != null)
                {
                    OnCompletion(obj);
                }
            };
            parser.OnGroupError += () =>
            {
                if (OnGroupError != null)
                {
                    OnGroupError();
                }
            };
            parser.OnNotLoadedError += () =>
            {
                if (OnNotLoadedError != null)
                {
                    OnNotLoadedError();
                }
            };
            parser.OnInternalError += () =>
            {
                if (OnInternalError != null)
                {
                    OnInternalError();
                }
            };
            parser.OnLexicalError += (pos, obj) =>
            {
                if (OnLexicalError != null)
                {
                    OnLexicalError(pos, obj);
                }
            };
            parser.OnSyntaxError += (pos, obj, expected) =>
            {
                if (OnSyntaxError != null)
                {
                    OnSyntaxError(pos, obj, expected);
                }
            };
        }

        public bool LoadGrammar(BinaryReader reader)
        {
            return parser.LoadEGT(reader);
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
            return parser.Parse();
        }

        protected abstract object CreateObjectFor(Reduction r);
    }
}
