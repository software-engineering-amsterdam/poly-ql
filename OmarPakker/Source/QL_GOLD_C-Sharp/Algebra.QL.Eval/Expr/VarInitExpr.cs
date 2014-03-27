using System;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class VarInitExpr<E, T> : Algebra.Core.Expr.VarInitExpr<E, T>, IEvalExpr
        where E : IEvalExpr
    {
        public VarInitExpr(string name, T type, E value)
            : base(name, type, value)
        {

        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            if (!env.IsDeclared(Name))
            {
                ValueContainer a = Value.Evaluate(env);
                ValueContainer value = new ValueContainer(a.Value);

                Action onValueChanged = () => value.Value = a.Value;
                a.ValueChanged += onValueChanged;

                env.Declare(Name, value);

                return value;
            }

            return env.GetDeclared(Name);
        }
    }
}
