using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class GreaterThenExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public GreaterThenExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
