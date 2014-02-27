using System;
using Algebra.Core.Tree;

namespace Algebra.Core.Factory
{
    public abstract class CombinedItems<T1, T2> : INode
        where T1 : INode
        where T2 : INode
    {
        public T1 Item1 { get; private set; }
        public T2 Item2 { get; private set; }

        public Tuple<int, int> SourcePosition
        {
            get
            {
                return Item1.SourcePosition;
            }
            set
            {
                Item1.SourcePosition = Item2.SourcePosition = value;
            }
        }

        public CombinedItems(T1 t1, T2 t2)
        {
            Item1 = t1;
            Item2 = t2;
        }
    }
}
