using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IFormExpr, IFormStmnt>, IFormStmnt
	{
        public IfElseStmnt(IFormExpr check, IFormStmnt ifTrue, IFormStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

        public FrameworkElement BuildForm()
        {
            FrameworkElement trueElem = IfTrueBody.BuildForm();
            FrameworkElement falseElem = IfFalseBody.BuildForm();
            StackPanel sp = new StackPanel();
            sp.Children.Add(trueElem);
            sp.Children.Add(falseElem);

            CheckExpression.BuildForm();
            bool value = (bool)CheckExpression.ExpressionValue;
            trueElem.Visibility = value ? Visibility.Visible : Visibility.Collapsed;
            falseElem.Visibility = !value ? Visibility.Visible : Visibility.Collapsed;

            CheckExpression.ValueChanged += () =>
            {
                bool newValue = (bool)CheckExpression.ExpressionValue;
                trueElem.Visibility = newValue ? Visibility.Visible : Visibility.Collapsed;
                falseElem.Visibility = !newValue ? Visibility.Visible : Visibility.Collapsed;
            };

            return sp;
        }
	}
}
