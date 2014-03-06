using System;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
	public class RealType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new RealLiteral(0); } }

		public RealType()
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
                bool hasDot = false;
                tb.Text = String.IsNullOrWhiteSpace(tb.Text) ? "0"
                    : String.Join("", tb.Text.Where(c => 
                        {
                            if(Char.IsNumber(c))
                            {
                                return true;
                            }
                            else if (!hasDot && c == '.')
                            {
                                hasDot = true;
                                return true;
                            }
                            return false;
                        }));

                value.ExpressionValue = Convert.ToDouble(tb.Text);
            };
            value.ValueChanged += () =>
            {
                tb.Text = Convert.ToString(value.ExpressionValue);
            };
            return tb;
        }

		public override string ToString()
		{
			return "real";
		}
	}
}
