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
            FrameworkElement trueElem = IfTrueBody.BuildForm();
            StackPanel sp = new StackPanel();
            sp.Children.Add(trueElem);

            CheckExpression.BuildForm();
            trueElem.Visibility = (bool)CheckExpression.ExpressionValue ? Visibility.Visible : Visibility.Collapsed;

            CheckExpression.ValueChanged += () =>
            {
                trueElem.Visibility = (bool)CheckExpression.ExpressionValue ? Visibility.Visible : Visibility.Collapsed;
            };

            return sp;
        }
    }
}
