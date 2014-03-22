using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Type
{
	public class BoolType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new BoolLiteral(false); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public BoolType()
		{

		}

        public override FrameworkElement BuildElement(VarEnvironment env, bool editable)
        {
            CheckBox cb = new CheckBox() { IsEnabled = editable };
            cb.Checked += (s, e) =>
            {
                ElementExpr.SetValue(env, true);
            };
            cb.Unchecked += (s, e) =>
            {
                ElementExpr.SetValue(env, false);
            };

            Action onValueChanged = () =>
            {
                cb.IsChecked = Convert.ToBoolean(ElementExpr.Eval(env));
            };
            onValueChanged();

            bool lastValue = cb.IsChecked.Value;
            cb.Loaded += (s, e) =>
            {
                ElementExpr.ValueChanged += onValueChanged;
                cb.IsChecked = lastValue;
            };
            cb.Unloaded += (s, e) =>
            {
                ElementExpr.ValueChanged -= onValueChanged;
                lastValue = Convert.ToBoolean(ElementExpr.Eval(env));
                cb.IsChecked = false;
            };

            return cb;
        }
	}
}
