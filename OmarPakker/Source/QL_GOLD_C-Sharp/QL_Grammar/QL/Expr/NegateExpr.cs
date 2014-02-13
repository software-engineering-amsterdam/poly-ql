using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class NegateExpr : SingleExprNode<IExprNode>, IExprNode
	{
		public NegateExpr(IExprNode e)
            : base(e)
		{
            
		}
	}
}
