using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Form.Stmnt
{
    public class FormsStmnt : CompStmnt<IFormStmnt>, IFormStmnt
    {
        public FormsStmnt(IFormStmnt a, IFormStmnt b)
            : base(a, b)
        {

        }

        public FrameworkElement BuildForm()
        {
            Style s = new Style();
            s.Setters.Add(new Setter(UIElement.VisibilityProperty, Visibility.Collapsed));

            TabControl t = new TabControl();// { ItemContainerStyle = s };
            t.Items.Add(Statement1.BuildForm());
            t.Items.Add(Statement2.BuildForm());

            return t;
        }
    }
}
