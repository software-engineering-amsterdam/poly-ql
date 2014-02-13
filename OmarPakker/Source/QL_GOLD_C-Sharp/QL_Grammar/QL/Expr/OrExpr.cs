using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class OrExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public OrExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{

		}
	}
}
