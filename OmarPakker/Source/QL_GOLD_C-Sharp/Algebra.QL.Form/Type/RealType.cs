using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Xceed.Wpf.Toolkit;

namespace Algebra.QL.Form.Type
{
	public class RealType : BaseType
	{
        public override IFormExpr DefaultValue { get { return new RealLiteral(0); } }
        public override IFormType SuperType { get { return new BaseType(); } }

		public RealType()
		{

		}

        public override FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            DoubleUpDown dud = new DoubleUpDown() { Width = 200, IsEnabled = editable, Increment = 0.01 };
            dud.ValueChanged += (s, e) =>
            {
                value.ExpressionValue = dud.Value;
            };

            Action onValueChanged = () =>
            {
                dud.Value = Convert.ToDouble(value.ExpressionValue);
            };
            value.ValueChanged -= onValueChanged;
            value.ValueChanged += onValueChanged;
            onValueChanged();

            return dud;
        }
	}
}
