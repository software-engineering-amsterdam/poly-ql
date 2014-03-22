using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public class IfStmnt : IfStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public IfStmnt(IFormExpr check, IFormStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            StackPanel sp = new StackPanel();
            sp.Children.Add(IfTrueBody.BuildForm(env));

            Action onValueChanged = () =>
            {
                sp.Visibility = Convert.ToBoolean(CheckExpression.Eval(env)) ? Visibility.Visible : Visibility.Collapsed;
            };
            CheckExpression.BuildForm(env);
            onValueChanged();

            sp.Loaded += (s, e) => CheckExpression.ValueChanged += onValueChanged;
            sp.Unloaded += (s, e) => CheckExpression.ValueChanged -= onValueChanged;

            return sp;
        }
    }
}
