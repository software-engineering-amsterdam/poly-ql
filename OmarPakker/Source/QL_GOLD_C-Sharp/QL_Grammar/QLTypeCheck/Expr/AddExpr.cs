using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class AddExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public AddExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }
    }
}
