using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
	public class DateType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow); } }

		public DateType()
		{

		}

        public override FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable)
        {
            DatePicker dp = new DatePicker()
            {
                Width = 200,
                IsEnabled = editable,
                SelectedDate = Convert.ToDateTime(initialValue)
            };
            dp.SelectedDateChanged += (s, e) =>
            {
                value.ExpressionValue = dp.SelectedDate;
            };
            value.ValueChanged += () =>
            {
                dp.SelectedDate = Convert.ToDateTime(value.ExpressionValue);
            };
            return dp;
        }

		public override string ToString()
		{
			return "date";
		}
	}
}
