using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr.Literals
{
    public abstract class LiteralExpr<T, V> : QL.Core.Expr.LiteralExpr<T, V>, IEvalExpr
    {
        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            return new ValueContainer(Value);
        }
    }
}
