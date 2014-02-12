using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class SubtractExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public SubtractExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
