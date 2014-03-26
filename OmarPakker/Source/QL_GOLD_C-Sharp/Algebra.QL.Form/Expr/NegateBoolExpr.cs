using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class NegateBoolExpr : UnaryExpr<IFormExpr>, IFormExpr
    {
        public NegateBoolExpr(IFormExpr expr)
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

        public IFormType BuildForm(TypeEnvironment env)
        {
            return Expr1.BuildForm(env);
        }
    }
}
