using QL_Grammar.Algebra.Value;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class LiteralExpr : QL_Grammar.QLAlgebra.Expr.LiteralExpr, ITypeCheckExpr
	{
		public LiteralExpr(IValue value)
			: base(value)
		{

		}
	}
}
