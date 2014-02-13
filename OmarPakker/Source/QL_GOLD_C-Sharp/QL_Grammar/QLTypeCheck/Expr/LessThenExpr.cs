using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class LessThenExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public LessThenExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}
	}
}
