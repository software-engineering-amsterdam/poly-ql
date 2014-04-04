using System;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public abstract class BinaryExpr : Algebra.Core.Expr.BinaryExpr<IEvalExpr>, IEvalExpr
    {
        public BinaryExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {
            
        }

        protected abstract object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value);

        public ValueContainer Evaluate(IValueEnvironment env)
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
