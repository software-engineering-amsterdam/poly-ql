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

        public override FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable)
        {
            DoubleUpDown iud = new DoubleUpDown()
            {
                Width = 200,
                IsEnabled = editable,
                Increment = 0.01,
                Value = Convert.ToDouble(initialValue)
            };
            iud.ValueChanged += (s, e) =>
            {
                value.ExpressionValue = iud.Value;
            };
            value.ValueChanged += () =>
            {
                iud.Value = Convert.ToDouble(value.ExpressionValue);
            };
            return iud;
        }

		public override string ToString()
		{
			return "real";
		}
	}
}
