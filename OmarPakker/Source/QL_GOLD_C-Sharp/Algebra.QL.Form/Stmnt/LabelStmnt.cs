using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class LabelStmnt : TextExprStmnt<IFormExpr>, IFormStmnt
    {
        public LabelStmnt(string text, IFormExpr e)
            : base(text, e)
        {

        }

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();
            sp.Orientation = Orientation.Horizontal;
            sp.Children.Add(new Label() { Width = 200, Content = Text });
            sp.Children.Add(Expression.BuildForm().BuildElement(Expression, Expression.ExpressionValue, false));
            return sp;
        }
    }
}
