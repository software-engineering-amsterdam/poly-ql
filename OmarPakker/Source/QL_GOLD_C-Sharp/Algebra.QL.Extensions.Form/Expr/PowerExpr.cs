using System;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class PowerExpr : BinaryExpr, IFormExpr
    {
        public PowerExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Math.Pow(Convert.ToDouble(expr1Value.Value), Convert.ToDouble(expr2Value.Value));
        }
    }
}
