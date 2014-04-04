using System;
using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class IfElseExpr : TernaryExpr<IEvalExpr>, IEvalExpr
    {
        public IfElseExpr(IEvalExpr a, IEvalExpr b, IEvalExpr c)
            : base(a, b, c)
        {
            
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            ValueContainer a = Expr2.Evaluate(env);
            ValueContainer b = Expr3.Evaluate(env);
            ValueContainer value = new ValueContainer(Convert.ToBoolean(Expr1.Evaluate(env).Value) ? a.Value : b.Value);

            Action onValueChanged = () => value.Value = Convert.ToBoolean(Expr1.Evaluate(env).Value) ? a.Value : b.Value;
            a.ValueChanged += onValueChanged;
            b.ValueChanged += onValueChanged;

            return value;
        }
    }
}
