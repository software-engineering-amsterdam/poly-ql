using System;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class AndExpr : BinaryExpr, IFormExpr
    {
        public AndExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToBoolean(expr1Value.Value) && Convert.ToBoolean(expr2Value.Value);
        }
    }
}
