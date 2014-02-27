using System;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Stmnt
{
    public abstract class CompStmnt<S> : IStmntNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public S Statement1 { get; private set; }
        public S Statement2 { get; private set; }

        public CompStmnt(S a, S b)
        {
            Statement1 = a;
            Statement2 = b;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is CompStmnt<S>))
			{
				return false;
			}

			CompStmnt<S> other = (CompStmnt<S>)obj;
            return Statement1.Equals(other.Statement1) && Statement2.Equals(other.Statement2);
		}

		public override int GetHashCode()
		{
            return Statement1.GetHashCode() + Statement2.GetHashCode();
		}
    }
}
