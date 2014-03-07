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

        public override FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable)
        {
            IntegerUpDown iud = new IntegerUpDown()
            {
                Width = 200,
                IsEnabled = editable,
                Value = Convert.ToInt32(initialValue)
            };
            iud.ValueChanged += (s, e) =>
            {
                value.ExpressionValue = iud.Value;
            };
            value.ValueChanged += () =>
            {
                iud.Value = Convert.ToInt32(value.ExpressionValue);
            };
            return iud;
        }

		public override string ToString()
		{
			return "int";
		}
	}
}
