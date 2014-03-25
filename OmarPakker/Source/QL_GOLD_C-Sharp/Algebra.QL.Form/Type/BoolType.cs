using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Type
{
    public class BoolType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new BoolLiteral(false); } }
        public override IFormType SuperType { get { return new BaseType(); } }

        public BoolType()
        {

        }

        public override FrameworkElement BuildElement(ValueContainer value, bool editable)
        {
            CheckBox cb = new CheckBox() { IsEnabled = editable };
            cb.Checked += (s, e) =>
            {
                value.Value = true;
            };
            cb.Unchecked += (s, e) =>
            {
                value.Value = false;
            };

            Action onValueChanged = () =>
            {
                cb.IsChecked = Convert.ToBoolean(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            bool lastValue = cb.IsChecked.Value;
            cb.Loaded += (s, e) =>
            {
                cb.IsChecked = lastValue;
            };
            cb.Unloaded += (s, e) =>
            {
                lastValue = Convert.ToBoolean(value.Value);
                cb.IsChecked = false;
            };

            return cb;
        }
    }
}
