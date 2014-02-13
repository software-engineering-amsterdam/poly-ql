using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class NotEqualExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public NotEqualExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
