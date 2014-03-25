using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public IfElseStmnt(IFormExpr check, IFormStmnt ifTrue, IFormStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
        {

        }

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            ValueContainer value = CheckExpression.BuildForm(env);

            FrameworkElement trueElem = IfTrueBody.BuildForm(env);
            FrameworkElement falseElem = IfFalseBody.BuildForm(env);

            Action onValueChanged = () =>
            {
                bool boolValue = Convert.ToBoolean(value.Value);
                trueElem.Visibility = boolValue ? Visibility.Visible : Visibility.Collapsed;
                falseElem.Visibility = !boolValue ? Visibility.Visible : Visibility.Collapsed;
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            StackPanel sp = new StackPanel();
            sp.Children.Add(trueElem);
            sp.Children.Add(falseElem);

            return sp;
        }
    }
}
