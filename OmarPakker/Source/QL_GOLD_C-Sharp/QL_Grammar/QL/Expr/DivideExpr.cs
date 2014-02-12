using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class DivideExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public DivideExpr(IExprNode l, IExprNode r)
            : base(l, r)
		{
			
		}
	}
}
