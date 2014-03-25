using System;
using System.Windows;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Value;
using Xceed.Wpf.Toolkit;

namespace Algebra.QL.Form.Type
{
    public class IntType : BaseType
    {
        public override IFormExpr DefaultValue { get { return new IntLiteral(0); } }
        public override IFormType SuperType { get { return new RealType(); } }

        public IntType()
        {

        }

        public override FrameworkElement BuildElement(ValueContainer value, bool editable)
        {
            IntegerUpDown iud = new IntegerUpDown() { Width = 200, IsEnabled = editable };
            iud.ValueChanged += (s, e) =>
            {
                value.Value = iud.Value;
            };
            
            Action onValueChanged = () =>
            {
                iud.Value = Convert.ToInt32(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            int lastValue = Convert.ToInt32(value.Value);
            iud.Loaded += (s, e) =>
            {
                iud.Value = lastValue;
            };
            iud.Unloaded += (s, e) =>
            {
                lastValue = Convert.ToInt32(value.Value);
                iud.Value = 0;
            };

            return iud;
        }
    }
}
