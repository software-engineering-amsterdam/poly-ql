using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class AndExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public AndExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }
	}
}
