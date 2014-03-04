using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    public class Reduction : Token
    {
        public int Count { get { return tokenList.Count; } }
        private IList<Token> tokenList;

        public Production Production { get; internal set; }
        public override object Tag { get; set; }

        internal Reduction(int size, Symbol parent)
            : base(parent, null)
        {
            tokenList = Enumerable.Repeat<Token>(null, size).ToList();
        }

        public Token this[int index]
        {
            get
            {
                return tokenList[index];
            }

            internal set
            {
                tokenList[index] = value;
            }
        }
    }
}
