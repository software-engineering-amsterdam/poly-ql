using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class EqualsExpr : BinaryExpr, IFormExpr
    {
        public EqualsExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return expr1Value.Value.Equals(expr2Value.Value);
        }
    }
}
