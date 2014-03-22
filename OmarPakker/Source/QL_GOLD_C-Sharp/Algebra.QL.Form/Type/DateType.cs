using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Type
{
	public class DateType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow.Date); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public DateType()
		{

		}

        public override FrameworkElement BuildElement(VarEnvironment env, bool editable)
        {
            DatePicker dp = new DatePicker() { Width = 200, IsEnabled = editable };
            dp.SelectedDateChanged += (s, e) =>
            {
                Value.SetValue(env, dp.SelectedDate);
            };

            Action onValueChanged = () =>
            {
                dp.SelectedDate = Convert.ToDateTime(Value.Eval(env));
            };
            onValueChanged();

            DateTime lastValue = Convert.ToDateTime(Value.Eval(env));
            dp.Loaded += (s, e) =>
            {
                Value.ValueChanged += onValueChanged;
                dp.SelectedDate = lastValue;
            };
            dp.Unloaded += (s, e) =>
            {
                Value.ValueChanged -= onValueChanged;
                lastValue = Convert.ToDateTime(Value.Eval(env));
                dp.SelectedDate = Convert.ToDateTime(DefaultValue.Eval(env));
            };

            return dp;
        }
	}
}
