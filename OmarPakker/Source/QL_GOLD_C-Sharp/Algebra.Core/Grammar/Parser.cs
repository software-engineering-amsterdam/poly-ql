using System;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.IO;
using GOLD.Engine;

namespace Algebra.Core.Grammar
{
    public abstract class Parser
    {
        //TODO: Delegate or Action<>?
        public event Action<Tuple<int, int>, Tuple<int, int>, object> OnReduction;
        public event Action<object> OnCompletion
        {
            add { parser.OnCompletion += value; }
            remove { parser.OnCompletion -= value; }
        }
        public event Action OnGroupError
        {
            add { parser.OnGroupError += value; }
            remove { parser.OnGroupError -= value; }
        }
        public event Action OnInternalError
        {
            add { parser.OnInternalError += value; }
            remove { parser.OnInternalError -= value; }
        }
        public event Action OnNotLoadedError
        {
            add { parser.OnNotLoadedError += value; }
            remove { parser.OnNotLoadedError -= value; }
        }
        public event Action<Tuple<int, int>, object> OnLexicalError
        {
            add { parser.OnLexicalError += value; }
            remove { parser.OnLexicalError -= value; }
        }
        public event Action<Tuple<int, int>, object, string> OnSyntaxError
        {
            add { parser.OnSyntaxError += value; }
            remove { parser.OnSyntaxError -= value; }
        }

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

                Debug.Assert(newObj != null, "Object construction failed. Are you missing a grammar value check?");

                if (OnReduction != null)
                {
                    OnReduction(start, end, newObj);
                }
            };
        }

        public bool LoadGrammar(BinaryReader reader)
        {
            return parser.LoadEGT(reader);
        }

        public bool Parse(string text)
        {
            return parser.Parse(ref text);
        }

        public bool Parse(TextReader reader)
        {
            return parser.Parse(reader);
        }

        protected abstract object CreateObjectFor(Reduction r);
    }
}
