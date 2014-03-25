using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<IFormExpr>, IFormStmnt
    {
        public QuestionStmnt(string text, IFormExpr e)
            : base(text, e)
        {

        }

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            StackPanel sp = new StackPanel();
            sp.Orientation = Orientation.Horizontal;
            sp.Children.Add(new Label() { Width = 200, Content = Text });
            
            ValueContainer value = Expression.BuildForm(env);
            sp.Children.Add(value.ValueType.BuildElement(value, true));

            return sp;
        }
    }
}
