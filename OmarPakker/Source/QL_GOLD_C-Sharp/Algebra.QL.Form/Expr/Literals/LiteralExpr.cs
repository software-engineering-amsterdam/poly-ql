using Algebra.QL.Core.Expr;
using Algebra.QL.Form.Environment;
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

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            return new ValueContainer(Value);
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return Type;
        }
    }
}
