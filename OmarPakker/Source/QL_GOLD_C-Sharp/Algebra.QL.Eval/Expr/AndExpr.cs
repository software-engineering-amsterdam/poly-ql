using System;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class AndExpr : BinaryExpr, IEvalExpr
    {
        public AndExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToBoolean(expr1Value.Value) && Convert.ToBoolean(expr2Value.Value);
        }
    }
}
