using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public class FormsStmnt : CompStmnt<IFormStmnt>, IFormStmnt
    {
        public FormsStmnt(IFormStmnt a, IFormStmnt b)
            : base(a, b)
        {

        }

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            Style s = new Style();
            s.Setters.Add(new Setter(UIElement.VisibilityProperty, Visibility.Collapsed));
            s.Setters.Add(new Setter(FrameworkElement.MarginProperty, new Thickness(0)));

            TabControl t = new TabControl() { ItemContainerStyle = s };
            t.Margin = new Thickness(0);
            t.Padding = new Thickness(0);
            t.BorderThickness = new Thickness(0);
            t.Items.Add(Statement1.BuildForm(env));
            t.Items.Add(Statement2.BuildForm(env));

            return t;
        }
    }
}
