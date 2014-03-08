using System;
using System.Windows;
using System.Windows.Controls;
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

        public override FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            TextBox tb = new TextBox() { Width = 200, IsEnabled = editable };
            tb.TextChanged += (s, e) =>
            {
                value.ExpressionValue = tb.Text;
            };

            Action onValueChanged = () =>
            {
                tb.Text = Convert.ToString(value.ExpressionValue);
            };
            value.ValueChanged -= onValueChanged;
            value.ValueChanged += onValueChanged;
            onValueChanged();

            return tb;
        }
	}
}
