using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class IfElseExpr : TripleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public IfElseExpr(ITypeCheckExpr a, ITypeCheckExpr b, ITypeCheckExpr c)
            : base(a, b, c)
        {

        }
    }
}
