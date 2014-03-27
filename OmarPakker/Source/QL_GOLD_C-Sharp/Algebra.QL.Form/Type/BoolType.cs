using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Eval.Value;
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

        protected override FrameworkElement BuildElement(ValueContainer value)
        {
            CheckBox cb = new CheckBox();
            cb.Checked += (s, e) =>
            {
                value.Value = true;
            };
            cb.Unchecked += (s, e) =>
            {
                value.Value = false;
            };

            Action onValueChanged = () =>
            {
                cb.IsChecked = Convert.ToBoolean(value.Value);
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            return cb;
        }
    }
}
