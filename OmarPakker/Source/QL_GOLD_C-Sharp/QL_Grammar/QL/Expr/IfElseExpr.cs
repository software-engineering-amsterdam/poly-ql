using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class IfElseExpr : TripleExprNode<IExprNode>, IExprNode
    {
		public IfElseExpr(IExprNode a, IExprNode b, IExprNode c)
            : base(a, b, c)
        {

        }
    }
}
