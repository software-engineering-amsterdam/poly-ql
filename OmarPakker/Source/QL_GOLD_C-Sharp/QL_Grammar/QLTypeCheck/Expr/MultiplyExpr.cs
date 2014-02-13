using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class MultiplyExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public MultiplyExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
