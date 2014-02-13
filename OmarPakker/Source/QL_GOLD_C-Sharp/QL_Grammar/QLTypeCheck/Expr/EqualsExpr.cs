using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class EqualsExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public EqualsExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
