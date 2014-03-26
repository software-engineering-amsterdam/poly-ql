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

        protected override FrameworkElement BuildElement(ValueContainer value)
        {
            DatePicker dp = new DatePicker() { Width = 200 };
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

            return dp;
        }
    }
}
