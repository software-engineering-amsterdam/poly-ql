using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
	public class DateType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow.Date); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public DateType()
		{

		}

        public override FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            DatePicker dp = new DatePicker() { Width = 200, IsEnabled = editable };
            dp.SelectedDateChanged += (s, e) =>
            {
                value.ExpressionValue = dp.SelectedDate;
            };

            Action onValueChanged = () =>
            {
                dp.SelectedDate = Convert.ToDateTime(value.ExpressionValue);
            };
            onValueChanged();

            dp.Loaded += (s, e) => value.ValueChanged += onValueChanged;
            dp.Unloaded += (s, e) => value.ValueChanged -= onValueChanged;

            return dp;
        }
	}
}
