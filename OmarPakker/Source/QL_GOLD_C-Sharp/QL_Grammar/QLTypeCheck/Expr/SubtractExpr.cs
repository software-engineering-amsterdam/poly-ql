using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class SubtractExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public SubtractExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
