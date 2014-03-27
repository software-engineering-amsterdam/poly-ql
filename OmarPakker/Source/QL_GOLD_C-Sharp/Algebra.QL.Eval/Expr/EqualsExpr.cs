using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class EqualsExpr<E> : BinaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public EqualsExpr(E l, E r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return expr1Value.Value.Equals(expr2Value.Value);
        }
    }
}
