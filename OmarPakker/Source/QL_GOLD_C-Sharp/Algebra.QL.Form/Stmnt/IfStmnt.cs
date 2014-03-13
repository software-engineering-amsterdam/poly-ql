using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class IfStmnt : IfStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public IfStmnt(IFormExpr check, IFormStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();
            sp.Children.Add(IfTrueBody.BuildForm());

            Action onValueChanged = () =>
            {
                sp.Visibility = (bool)CheckExpression.ExpressionValue ? Visibility.Visible : Visibility.Collapsed;
            };
            onValueChanged();

            sp.Loaded += (s, e) => CheckExpression.ValueChanged += onValueChanged;
            sp.Unloaded += (s, e) => CheckExpression.ValueChanged -= onValueChanged;

            return sp;
        }

        public IFormStmnt Clone()
        {
            return new IfStmnt(CheckExpression.Clone(), IfTrueBody.Clone());
        }

        public void Dispose()
        {
            CheckExpression.Dispose();
            IfTrueBody.Dispose();
        }
    }
}
