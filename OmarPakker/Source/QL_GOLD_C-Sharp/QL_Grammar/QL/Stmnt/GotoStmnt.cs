using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
    public class GotoStmnt : GotoStmntNode, IStmntNode
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}
    }
}
