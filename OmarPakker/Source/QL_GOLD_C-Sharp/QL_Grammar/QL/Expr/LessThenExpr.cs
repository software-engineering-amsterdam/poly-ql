using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class LessThenExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public LessThenExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
