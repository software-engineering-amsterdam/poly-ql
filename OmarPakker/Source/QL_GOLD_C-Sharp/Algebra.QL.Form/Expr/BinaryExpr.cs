using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public abstract class BinaryExpr : BinaryExpr<IFormExpr>, IFormExpr
    {
        public BinaryExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {
            
        }

        protected abstract object Evaluate(ValueContainer expr1Value, ValueContainer expr2Value);

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            ValueContainer a = Expr1.Evaluate(env);
            ValueContainer b = Expr2.Evaluate(env);
            ValueContainer value = new ValueContainer(Evaluate(a, b));

            Action onValueChanged = () => value.Value = Evaluate(a, b);
            a.ValueChanged += onValueChanged;
            b.ValueChanged += onValueChanged;

            return value;
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            IFormType a = Expr1.BuildForm(env);
            IFormType b = Expr2.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }
    }
}
