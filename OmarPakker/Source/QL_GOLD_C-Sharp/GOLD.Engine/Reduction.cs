using System;
using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    public class Reduction : Token
    {
        public Production Production { get; private set; }
        public int Count { get { return tokenList.Count; } }
        
        public override Tuple<int, int> StartPosition
        {
            get { return Count > 0 ? this[0].StartPosition : base.StartPosition; }
            internal set { base.StartPosition = value; }
        }
        public override Tuple<int, int> EndPosition
        {
            get { return Count > 0 ? this[Count - 1].EndPosition : base.EndPosition; }
            internal set { base.EndPosition = value; }
        }
        public override object Tag { get; set; }

        private IList<Token> tokenList;

        internal Reduction(int size, Production prod)
            : base(prod.Head, null)
        {
            tokenList = Enumerable.Repeat<Token>(null, size).ToList();
            Production = prod;
        }

        public Token this[int index]
        {
            get { return tokenList[index]; }
            internal set { tokenList[index] = value; }
        }
    }
}
