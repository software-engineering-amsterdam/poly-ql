using System;
using System.Windows;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Xceed.Wpf.Toolkit;

namespace Algebra.QL.Form.Type
{
    public class RealType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new RealLiteral(0); } }
        public override IFormType SuperType { get { return new BaseType(); } }

        public RealType()
        {

        }

        protected override FrameworkElement BuildElement(ValueContainer value)
        {
            DoubleUpDown dud = new DoubleUpDown() { Width = 200, Increment = 0.1 };
            dud.ValueChanged += (s, e) =>
            {
                value.Value = dud.Value;
            };

            Action onValueChanged = () =>
            {
                dud.Value = Convert.ToDouble(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            return dud;
        }
    }
}
