using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class LessOrEqualToExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public LessOrEqualToExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
