using System;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Extensions.Eval.Expr
{
    public class PowerExpr<E> : BinaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public PowerExpr(E l, E r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Math.Pow(Convert.ToDouble(expr1Value.Value), Convert.ToDouble(expr2Value.Value));
        }
    }
}
