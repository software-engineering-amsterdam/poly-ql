using System;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
	public class IntType : RealType
	{
        public override IFormExpr DefaultValue { get { return new IntLiteral(0); } }

		public IntType()
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
                tb.Text = String.IsNullOrWhiteSpace(tb.Text) ? "0"
                    : String.Join("", tb.Text.Where(c => Char.IsNumber(c)));

                value.ExpressionValue = Convert.ToInt32(tb.Text);
            };
            value.ValueChanged += () =>
            {
                tb.Text = Convert.ToString(value.ExpressionValue);
            };
            return tb;
        }

		public override string ToString()
		{
			return "int";
		}
	}
}
