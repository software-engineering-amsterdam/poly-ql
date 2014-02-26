using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class LiteralExpr : Algebra.QL.Core.Expr.LiteralExpr, ITypeCheckExpr
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
