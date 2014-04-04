using System;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class SubtractExpr : BinaryExpr, IEvalExpr
    {
        public SubtractExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToDouble(expr1Value.Value) - Convert.ToDouble(expr2Value.Value);
        }
    }
}
