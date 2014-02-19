using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class LiteralExpr : QL_Grammar.QLAlgebra.Expr.LiteralExpr, ITypeCheckExpr
	{
		public LiteralExpr(IValue value)
			: base(value)
		{

		}

        public IType TypeCheck(TypeCheckData data)
        {
            return Value.Type;
        }
    }
}
