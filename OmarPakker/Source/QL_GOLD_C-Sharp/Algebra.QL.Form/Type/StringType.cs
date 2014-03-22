using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Type
{
	public class StringType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new StringLiteral(String.Empty); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public StringType()
		{

		}

        public override FrameworkElement BuildElement(VarEnvironment env, bool editable)
        {
            TextBox tb = new TextBox() { Width = 200, IsEnabled = editable };
            tb.TextChanged += (s, e) =>
            {
                Value.SetValue(env, tb.Text);
            };

            Action onValueChanged = () =>
            {
                tb.Text = Convert.ToString(Value.Eval(env));
            };
            onValueChanged();

            string lastValue = Convert.ToString(Value.Eval(env));
            tb.Loaded += (s, e) =>
            {
                Value.ValueChanged += onValueChanged;
                tb.Text = lastValue;
            };
            tb.Unloaded += (s, e) =>
            {
                Value.ValueChanged -= onValueChanged;
                lastValue = Convert.ToString(Value.Eval(env));
                tb.Text = String.Empty;
            };

            return tb;
        }
	}
}
