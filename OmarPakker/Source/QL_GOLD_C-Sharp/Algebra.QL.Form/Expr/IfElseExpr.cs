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

        public ValueContainer BuildForm(VarEnvironment env)
        {
            ValueContainer a = Expr2.BuildForm(env);
            ValueContainer b = Expr3.BuildForm(env);
            IFormType type = a.ValueType.GetLeastUpperBound(b.ValueType);

            ValueContainer value = new ValueContainer(type, Convert.ToBoolean(Expr1.BuildForm(env).Value) ? a.Value : b.Value);

            Action onValueChanged = () => value.Value = Convert.ToBoolean(Expr1.BuildForm(env).Value) ? a.Value : b.Value;
            a.ValueChanged += onValueChanged;
            b.ValueChanged += onValueChanged;

            return value;
        }
    }
}
