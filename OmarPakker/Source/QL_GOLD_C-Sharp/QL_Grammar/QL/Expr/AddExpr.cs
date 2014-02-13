using QL_Grammar.AST.Expr;

namespace QL_Grammar.QL.Expr
{
	public class AddExpr : DoubleExprNode<IExprNode>, IExprNode
    {
		public AddExpr(IExprNode l, IExprNode r)
            : base(l, r)
        {

        }
    }
}
