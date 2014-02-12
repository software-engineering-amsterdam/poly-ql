using System;

namespace QL_Grammar.AST.Stmnt
{
    public class GotoStmntNode : IStmntNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string GotoName { get; private set; }

		public GotoStmntNode(string gotoName)
		{
            GotoName = gotoName;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is GotoStmntNode))
			{
				return false;
			}

			return GotoName.Equals(((GotoStmntNode)obj).GotoName);
		}
    }
}
