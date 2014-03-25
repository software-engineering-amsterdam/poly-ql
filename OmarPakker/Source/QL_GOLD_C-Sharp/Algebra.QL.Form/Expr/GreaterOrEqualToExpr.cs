using System;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class GreaterOrEqualToExpr : BinaryExpr, IFormExpr
    {
        public GreaterOrEqualToExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToDouble(expr1Value.Value) >= Convert.ToDouble(expr2Value.Value);
        }
    }
}
