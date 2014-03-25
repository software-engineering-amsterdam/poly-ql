using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Value;
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

        public override FrameworkElement BuildElement(ValueContainer value, bool editable)
        {
            DoubleUpDown dud = new DoubleUpDown() { Width = 200, IsEnabled = editable, Increment = 0.1 };
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

            double lastValue = Convert.ToDouble(value.Value);
            dud.Loaded += (s, e) =>
            {
                dud.Value = lastValue;
            };
            dud.Unloaded += (s, e) =>
            {
                lastValue = Convert.ToDouble(value.Value);
                dud.Value = 0;
            };

            return dud;
        }
    }
}
