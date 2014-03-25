using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class NegateNumericExpr : UnaryExpr<IFormExpr>, IFormExpr
    {
        public NegateNumericExpr(IFormExpr expr)
            : base(expr)
        {
            
        }

        public ValueContainer BuildForm(VarEnvironment env)
        {
            ValueContainer a = Expr1.BuildForm(env);
            
            ValueContainer value = new ValueContainer(a.ValueType, -Convert.ToDouble(a.Value));

            Action onValueChanged = () => value.Value = -Convert.ToDouble(a.Value);
            a.ValueChanged += onValueChanged;

            return value;
        }
    }
}
