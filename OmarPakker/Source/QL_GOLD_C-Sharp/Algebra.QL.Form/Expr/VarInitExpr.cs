using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public VarInitExpr(string name, IFormType type)
            : base(name, type, type.DefaultValue)
        {
            
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value)
            : base(name, type, value)
        {

        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            if (!env.IsDeclared(Name) || !env.IsRepeated(Name))
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

        public IFormType BuildForm(TypeEnvironment env)
        {
            if (!env.IsDeclared(Name) || !env.IsRepeated(Name))
            {
                env.Declare(Name, Type);
            }

            return Type;
        }
    }
}
