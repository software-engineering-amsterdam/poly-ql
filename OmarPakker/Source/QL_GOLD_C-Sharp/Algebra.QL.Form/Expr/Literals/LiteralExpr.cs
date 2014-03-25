using Algebra.QL.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<IFormType, V>, IFormExpr
    {
        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public ValueContainer BuildForm(VarEnvironment env)
        {
            return new ValueContainer(Type, Value);
        }
    }
}
