using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : TernaryExpr<IFormExpr>, IFormExpr
    {
        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
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

        public IFormType BuildForm(TypeEnvironment env)
        {
            IFormType a = Expr2.BuildForm(env);
            IFormType b = Expr3.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }
    }
}
