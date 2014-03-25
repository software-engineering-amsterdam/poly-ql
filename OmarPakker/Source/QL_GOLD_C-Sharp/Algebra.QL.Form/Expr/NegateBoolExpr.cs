using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class NegateBoolExpr : UnaryExpr<IFormExpr>, IFormExpr
    {
        public NegateBoolExpr(IFormExpr expr)
            : base(expr)
        {
            
        }

        public ValueContainer BuildForm(VarEnvironment env)
        {
            ValueContainer a = Expr1.BuildForm(env);

            ValueContainer value = new ValueContainer(a.ValueType, !Convert.ToBoolean(a.Value));

            Action onValueChanged = () => value.Value = !Convert.ToBoolean(a.Value);
            a.ValueChanged += onValueChanged;

            return value;
        }
    }
}
