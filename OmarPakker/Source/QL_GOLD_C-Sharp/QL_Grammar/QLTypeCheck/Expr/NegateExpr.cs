using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class NegateExpr : SingleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public NegateExpr(ITypeCheckExpr e)
            : base(e)
		{
            
		}
	}
}
