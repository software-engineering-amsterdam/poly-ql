using System;
using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class NegateNumericExpr : UnaryExpr<IEvalExpr>, IEvalExpr
    {
        public NegateNumericExpr(IEvalExpr expr)
            : base(expr)
        {
            
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            ValueContainer a = Expr1.Evaluate(env);
            ValueContainer value = new ValueContainer(-Convert.ToDouble(a.Value));

            Action onValueChanged = () => value.Value = -Convert.ToDouble(a.Value);
            a.ValueChanged += onValueChanged;

            return value;
        }
    }
}
