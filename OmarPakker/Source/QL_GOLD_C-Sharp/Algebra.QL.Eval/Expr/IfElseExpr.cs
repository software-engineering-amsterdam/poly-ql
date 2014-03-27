using System;
using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class IfElseExpr<E> : TernaryExpr<E>, IEvalExpr
        where E : IEvalExpr
    {
        public IfElseExpr(E a, E b, E c)
            : base(a, b, c)
        {
            
        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            ValueContainer a = Expr2.Evaluate(env);
            ValueContainer b = Expr3.Evaluate(env);
            ValueContainer value = new ValueContainer(Convert.ToBoolean(Expr1.Evaluate(env).Value) ? a.Value : b.Value);

            Action onValueChanged = () => value.Value = Convert.ToBoolean(Expr1.Evaluate(env).Value) ? a.Value : b.Value;
            a.ValueChanged += onValueChanged;
            b.ValueChanged += onValueChanged;

            return value;
        }
    }
}
