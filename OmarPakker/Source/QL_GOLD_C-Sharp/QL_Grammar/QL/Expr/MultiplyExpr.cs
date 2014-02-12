using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class MultiplyExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public MultiplyExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
