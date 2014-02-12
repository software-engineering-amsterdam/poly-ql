using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class AndExpr : DoubleExprNode<IExprNode>, IExprNode
	{
		public AndExpr(IExprNode l, IExprNode r)
            : base(l, r)
        {

        }
	}
}
