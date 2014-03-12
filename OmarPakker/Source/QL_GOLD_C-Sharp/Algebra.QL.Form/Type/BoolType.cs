using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;

namespace Algebra.QL.Form.Type
{
	public class BoolType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new BoolLiteral(false); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public BoolType()
		{

		}

        public override FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            CheckBox cb = new CheckBox() { IsEnabled = editable };
            cb.Checked += (s, e) =>
            {
                value.ExpressionValue = true;
            };
            cb.Unchecked += (s, e) =>
            {
                value.ExpressionValue = false;
            };

            Action onValueChanged = () =>
            {
                cb.IsChecked = Convert.ToBoolean(value.ExpressionValue);
            };
            onValueChanged();

            cb.Loaded += (s, e) => value.ValueChanged += onValueChanged;
            cb.Unloaded += (s, e) => value.ValueChanged -= onValueChanged;

            return cb;
        }
	}
}
