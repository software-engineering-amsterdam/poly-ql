using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Form.Expr.Literals;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Type
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
                ElementExpr.SetValue(env, dp.SelectedDate);
            };

            Action onValueChanged = () =>
            {
                dp.SelectedDate = Convert.ToDateTime(ElementExpr.Eval(env));
            };
            onValueChanged();

            DateTime lastValue = Convert.ToDateTime(ElementExpr.Eval(env));
            dp.Loaded += (s, e) =>
            {
                ElementExpr.ValueChanged += onValueChanged;
                dp.SelectedDate = lastValue;
            };
            dp.Unloaded += (s, e) =>
            {
                ElementExpr.ValueChanged -= onValueChanged;
                lastValue = Convert.ToDateTime(ElementExpr.Eval(env));
                dp.SelectedDate = Convert.ToDateTime(DefaultValue.Eval(env));
            };

            return dp;
        }
	}
}
