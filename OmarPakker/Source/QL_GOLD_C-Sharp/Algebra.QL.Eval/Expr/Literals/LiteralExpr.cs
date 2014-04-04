using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr.Literals
{
    public class LiteralExpr<V> : Algebra.Core.Expr.LiteralExpr<V>, IEvalExpr
    {
        public LiteralExpr(V value)
            : base(value)
        {

        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return new ValueContainer(Value);
        }
    }
}
