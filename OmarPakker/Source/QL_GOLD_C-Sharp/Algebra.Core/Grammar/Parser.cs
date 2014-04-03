using System;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.IO;

namespace Algebra.Core.Grammar
{
    public abstract class Parser
    {
        public event Action<Tuple<int, int>, Tuple<int, int>, object> OnReduction;
        public event Action<object> OnCompletion
        {
            add { parser.Completed += value; }
            remove { parser.Completed -= value; }
        }
        public event Action OnGroupError
        {
            add { parser.GroupError += value; }
            remove { parser.GroupError -= value; }
        }
        public event Action OnInternalError
        {
            add { parser.InternalError += value; }
            remove { parser.InternalError -= value; }
        }
        public event Action OnNotLoadedError
        {
            add { parser.NotLoadedError += value; }
            remove { parser.NotLoadedError -= value; }
        }
        public event Action<Tuple<int, int>, string> OnLexicalError
        {
            add { parser.LexicalError += value; }
            remove { parser.LexicalError -= value; }
        }
        public event Action<Tuple<int, int>, string, string> OnSyntaxError
        {
            add { parser.SyntaxError += value; }
            remove { parser.SyntaxError -= value; }
        }

        private GOLD.Engine.Parser parser;

        protected abstract ReadOnlyDictionary<ushort, string> Rules { get; }

        public Parser(bool trimReductions)
        {
            parser = new GOLD.Engine.Parser();
            parser.TrimReductions = trimReductions;

            InitEvents();
        }

        private void InitEvents()
        {
            parser.Reduction += (reduction) =>
            {
                object newObj = CreateObjectFor(reduction);
                reduction.Tag = newObj;

                Debug.Assert(newObj != null, "Object construction failed. Are you missing a grammar value check?");

                if (OnReduction != null)
                {
                    OnReduction(reduction.StartPosition, reduction.EndPosition, reduction.Tag);
                }
            };
        }

        protected abstract object CreateObjectFor(GOLD.Engine.Reduction r);

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
    }
}
