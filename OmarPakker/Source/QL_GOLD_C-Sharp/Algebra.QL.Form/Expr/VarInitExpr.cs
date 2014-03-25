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

        public ValueContainer BuildForm(VarEnvironment env)
        {
            if (!env.IsDeclared(Name) || !env.IsRepeated(Name))
            {
                ValueContainer a = Value.BuildForm(env);
                ValueContainer value = new ValueContainer(Type, a.Value);

                Action onValueChanged = () => value.Value = a.Value;
                a.ValueChanged += onValueChanged;

                env.Declare(Name, value);

                return value;
            }

            return env.GetDeclared(Name);
        }
    }
}
