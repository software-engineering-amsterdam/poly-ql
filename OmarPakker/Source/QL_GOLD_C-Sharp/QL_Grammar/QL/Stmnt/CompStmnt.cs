using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
	public class CompStmnt : CompStmntNode<IStmntNode>, IStmntNode
    {
		public CompStmnt(params IStmntNode[] stmnts)
            : base(stmnts)
        {

        }
    }
}
