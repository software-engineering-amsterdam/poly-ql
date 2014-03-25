using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Form.Expr.Literals;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Extensions.Form.Type
{
    public class DateType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow.Date); } }
        public override IFormType SuperType { get { return new BaseType(); } }

        public DateType()
        {

        }

        public override FrameworkElement BuildElement(ValueContainer value, bool editable)
        {
            DatePicker dp = new DatePicker() { Width = 200, IsEnabled = editable };
            dp.SelectedDateChanged += (s, e) =>
            {
                value.Value = dp.SelectedDate;
            };

            Action onValueChanged = () =>
            {
                dp.SelectedDate = Convert.ToDateTime(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            DateTime lastValue = Convert.ToDateTime(value.Value);
            dp.Loaded += (s, e) =>
            {
                dp.SelectedDate = lastValue;
            };
            dp.Unloaded += (s, e) =>
            {
                lastValue = Convert.ToDateTime(value.Value);
                dp.SelectedDate = DateTime.UtcNow.Date;
            };

            return dp;
        }
    }
}
