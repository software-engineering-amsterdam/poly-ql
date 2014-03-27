using System;
using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class NegateBoolExpr<E> : UnaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public NegateBoolExpr(E expr)
            : base(expr)
        {
            
        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            ValueContainer a = Expr1.Evaluate(env);
            ValueContainer value = new ValueContainer(!Convert.ToBoolean(a.Value));

            Action onValueChanged = () => value.Value = !Convert.ToBoolean(a.Value);
            a.ValueChanged += onValueChanged;

            return value;
        }
    }
}
