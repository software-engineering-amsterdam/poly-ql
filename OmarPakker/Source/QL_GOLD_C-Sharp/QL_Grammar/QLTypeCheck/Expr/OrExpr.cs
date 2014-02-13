using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class OrExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public OrExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
