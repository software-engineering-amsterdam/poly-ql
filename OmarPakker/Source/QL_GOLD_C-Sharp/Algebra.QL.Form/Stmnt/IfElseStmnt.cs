using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

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
            FrameworkElement trueElem = IfTrueBody.BuildForm(env);
            FrameworkElement falseElem = IfFalseBody.BuildForm(env);
            StackPanel sp = new StackPanel();
            sp.Children.Add(trueElem);
            sp.Children.Add(falseElem);

            Action onValueChanged = () =>
            {
                bool value = Convert.ToBoolean(CheckExpression.Eval(env));
                trueElem.Visibility = value ? Visibility.Visible : Visibility.Collapsed;
                falseElem.Visibility = !value ? Visibility.Visible : Visibility.Collapsed;
            };
            CheckExpression.BuildForm(env);
            onValueChanged();

            sp.Loaded += (s, e) => CheckExpression.ValueChanged += onValueChanged;
            sp.Unloaded += (s, e) => CheckExpression.ValueChanged -= onValueChanged;

            return sp;
        }
	}
}
