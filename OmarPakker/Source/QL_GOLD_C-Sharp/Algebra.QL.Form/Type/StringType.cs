using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
    public class StringType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new StringLiteral(String.Empty); } }
        public override IFormType SuperType { get { return new BaseType(); } }

        public StringType()
        {

        }

        protected override FrameworkElement BuildElement(ValueContainer value)
        {
            TextBox tb = new TextBox() { Width = 200 };
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

            return tb;
        }
    }
}
