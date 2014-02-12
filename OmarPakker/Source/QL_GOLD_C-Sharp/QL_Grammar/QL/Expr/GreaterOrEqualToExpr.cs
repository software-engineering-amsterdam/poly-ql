using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
    public class GreaterOrEqualToExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public GreaterOrEqualToExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
