using System;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public abstract class BinaryExpr<E> : Algebra.Core.Expr.BinaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public BinaryExpr(E l, E r)
            : base(l, r)
        {
            
        }

        protected abstract object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value);

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            ValueContainer a = Expr1.Evaluate(env);
            ValueContainer b = Expr2.Evaluate(env);
            ValueContainer value = new ValueContainer(Evaluate(a, b));

            Action onValueChanged = () => value.Value = Evaluate(a, b);
            a.ValueChanged += onValueChanged;
            b.ValueChanged += onValueChanged;

            return value;
        }
    }
}
