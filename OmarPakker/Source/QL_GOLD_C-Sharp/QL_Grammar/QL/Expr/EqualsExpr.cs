using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class EqualsExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public EqualsExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
