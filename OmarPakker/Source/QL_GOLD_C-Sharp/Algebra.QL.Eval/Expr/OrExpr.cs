using System;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class OrExpr<E> : BinaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public OrExpr(E l, E r)
            : base(l, r)
        {

        }

        protected override object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value)
        {
            return Convert.ToBoolean(expr1Value.Value) || Convert.ToBoolean(expr2Value.Value);
        }
    }
}
