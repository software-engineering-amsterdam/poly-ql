using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class EqualsExpr : BinaryExpr, IEvalExpr
    {
        public EqualsExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return expr1Value.Value.Equals(expr2Value.Value);
        }
    }
}
