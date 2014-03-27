using System;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class LessThenExpr<E> : BinaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public LessThenExpr(E l, E r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToDouble(expr1Value.Value) < Convert.ToDouble(expr2Value.Value);
        }
    }
}
