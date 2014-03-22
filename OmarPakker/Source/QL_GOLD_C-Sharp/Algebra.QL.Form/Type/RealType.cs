using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Helpers;
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

        public override FrameworkElement BuildElement(VarEnvironment env, bool editable)
        {
            DoubleUpDown dud = new DoubleUpDown() { Width = 200, IsEnabled = editable, Increment = 0.1 };
            dud.ValueChanged += (s, e) =>
            {
                ElementExpr.SetValue(env, dud.Value);
            };

            Action onValueChanged = () =>
            {
                dud.Value = Convert.ToDouble(ElementExpr.Eval(env));
            };
            onValueChanged();

            double lastValue = Convert.ToDouble(ElementExpr.Eval(env));
            dud.Loaded += (s, e) =>
            {
                ElementExpr.ValueChanged += onValueChanged;
                dud.Value = lastValue;
            };
            dud.Unloaded += (s, e) =>
            {
                ElementExpr.ValueChanged -= onValueChanged;
                lastValue = Convert.ToDouble(ElementExpr.Eval(env));
                dud.Value = 0;
            };

            return dud;
        }
	}
}
