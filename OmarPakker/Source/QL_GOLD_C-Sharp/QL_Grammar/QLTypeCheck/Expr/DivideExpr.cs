using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class DivideExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public DivideExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{
			
		}
	}
}
