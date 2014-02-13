using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class GreaterOrEqualToExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public GreaterOrEqualToExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
