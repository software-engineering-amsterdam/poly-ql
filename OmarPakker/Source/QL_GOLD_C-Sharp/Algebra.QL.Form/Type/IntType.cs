using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Xceed.Wpf.Toolkit;

namespace Algebra.QL.Form.Type
{
	public class IntType : RealType
	{
        public override IFormExpr DefaultValue { get { return new IntLiteral(0); } }
        public override IFormType SuperType { get { return new RealType(); } }

		public IntType()
		{

		}

        public override FrameworkElement BuildElement(IFormExpr value, bool editable)
        {
            IntegerUpDown iud = new IntegerUpDown() { Width = 200, IsEnabled = editable };
            iud.ValueChanged += (s, e) =>
            {
                value.ExpressionValue = iud.Value;
            };

            Action onValueChanged = () =>
            {
                iud.Value = Convert.ToInt32(value.ExpressionValue);
            };
            value.ValueChanged -= onValueChanged;
            value.ValueChanged += onValueChanged;
            onValueChanged();

            return iud;
        }
	}
}
