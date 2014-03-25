using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

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
            ValueContainer value = CheckExpression.BuildForm(env);

            StackPanel sp = new StackPanel();
            Action onValueChanged = () =>
            {
                sp.Visibility = Convert.ToBoolean(value.Value) ? Visibility.Visible : Visibility.Collapsed;
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            sp.Children.Add(IfTrueBody.BuildForm(env));
            
            return sp;
        }
    }
}
