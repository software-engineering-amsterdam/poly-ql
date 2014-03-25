using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Type
{
    public class StringType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new StringLiteral(String.Empty); } }
        public override IFormType SuperType { get { return new BaseType(); } }

        public StringType()
        {

        }

        public override FrameworkElement BuildElement(ValueContainer value, bool editable)
        {
            TextBox tb = new TextBox() { Width = 200, IsEnabled = editable };
            tb.TextChanged += (s, e) =>
            {
                value.Value = tb.Text;
            };

            Action onValueChanged = () =>
            {
                tb.Text = Convert.ToString(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            string lastValue = Convert.ToString(value.Value);
            tb.Loaded += (s, e) =>
            {
                tb.Text = lastValue;
            };
            tb.Unloaded += (s, e) =>
            {
                lastValue = Convert.ToString(value.Value);
                tb.Text = String.Empty;
            };

            return tb;
        }
    }
}
