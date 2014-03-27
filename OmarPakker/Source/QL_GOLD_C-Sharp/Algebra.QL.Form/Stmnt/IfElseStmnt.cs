using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public IfElseStmnt(IFormExpr check, IFormStmnt ifTrue, IFormStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
        {

        }

        public FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv)
        {
            ValueContainer value = CheckExpression.Evaluate(vEnv);

            FrameworkElement trueElem = IfTrueBody.BuildForm(vEnv, tEnv);
            FrameworkElement falseElem = IfFalseBody.BuildForm(vEnv, tEnv);

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
