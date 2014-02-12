using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
	public class IfStmnt : IfStmntNode<IExprNode, IStmntNode>, IStmntNode
    {
		public IfStmnt(IExprNode check, IStmntNode ifTrue)
            : base(check, ifTrue)
		{

		}
    }
}
