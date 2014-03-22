using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Helpers;
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

        public override FrameworkElement BuildElement(VarEnvironment env, bool editable)
        {
            IntegerUpDown iud = new IntegerUpDown() { Width = 200, IsEnabled = editable };
            iud.ValueChanged += (s, e) =>
            {
                Value.SetValue(env, iud.Value);
            };
            
            Action onValueChanged = () =>
            {
                iud.Value = Convert.ToInt32(Value.Eval(env));
            };
            onValueChanged();

            int lastValue = Convert.ToInt32(Value.Eval(env));
            iud.Loaded += (s, e) =>
            {
                Value.ValueChanged += onValueChanged;
                iud.Value = lastValue;
            };
            iud.Unloaded += (s, e) =>
            {
                Value.ValueChanged -= onValueChanged;
                lastValue = Convert.ToInt32(Value.Eval(env));
                iud.Value = 0;
            };

            return iud;
        }
	}
}
