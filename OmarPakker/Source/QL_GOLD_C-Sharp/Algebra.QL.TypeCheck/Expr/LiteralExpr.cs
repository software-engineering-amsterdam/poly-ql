using Algebra.QL.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public abstract class LiteralExpr<V> : LiteralExpr<ITypeCheckType, V>, ITypeCheckExpr
	{
		protected LiteralExpr(V value)
			: base(value)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            return Type;
        }
    }
}
