using System;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Stmnt
{
    public abstract class GotoStmnt : IStmntNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public string GotoName { get; private set; }

		public GotoStmnt(string gotoName)
		{
            GotoName = gotoName;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is GotoStmnt))
			{
				return false;
			}

			return GotoName.Equals(((GotoStmnt)obj).GotoName);
		}

		public override int GetHashCode()
		{
			return GotoName.GetHashCode();
		}
    }
}
