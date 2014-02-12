using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
	public class IfElseStmnt : IfElseStmntNode<IExprNode, IStmntNode>, IStmntNode
	{
		public IfElseStmnt(IExprNode check, IStmntNode ifTrue, IStmntNode ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}
	}
}
