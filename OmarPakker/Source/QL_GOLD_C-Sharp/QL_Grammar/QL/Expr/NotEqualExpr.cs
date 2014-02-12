using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class NotEqualExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public NotEqualExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
