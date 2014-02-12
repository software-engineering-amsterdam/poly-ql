using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
    public class GreaterThenExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public GreaterThenExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
