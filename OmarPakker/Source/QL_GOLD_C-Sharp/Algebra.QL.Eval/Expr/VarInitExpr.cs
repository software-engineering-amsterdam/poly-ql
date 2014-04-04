using System;
using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class VarInitExpr<T> : VarInitExpr<IEvalExpr, T>, IEvalExpr
    {
        public VarInitExpr(string name, T type, IEvalExpr value)
            : base(name, type, value)
        {

        }

        public ValueContainer Evaluate(IValueEnvironment env)
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
