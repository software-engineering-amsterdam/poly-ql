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

        public override FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable)
        {
            TextBox tb = new TextBox()
            {
                Width = 200,
                IsEnabled = editable,
                Text = Convert.ToString(initialValue)
            };
            tb.TextChanged += (s, e) =>
            {
                value.ExpressionValue = tb.Text;
            };
            value.ValueChanged += () =>
            {
                tb.Text = Convert.ToString(value.ExpressionValue);
            };
            return tb;
        }

		public override string ToString()
		{
			return "string";
		}
	}
}
