using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class LessOrEqualToExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public LessOrEqualToExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
