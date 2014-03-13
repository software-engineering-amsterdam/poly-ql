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
            s.Setters.Add(new Setter(FrameworkElement.MarginProperty, new Thickness(0)));

            TabControl t = new TabControl() { ItemContainerStyle = s };
            t.Margin = new Thickness(0);
            t.Padding = new Thickness(0);
            t.BorderThickness = new Thickness(0);
            t.Items.Add(Statement1.BuildForm());
            t.Items.Add(Statement2.BuildForm());

            return t;
        }

        public IFormStmnt Clone()
        {
            return new FormsStmnt(Statement1.Clone(), Statement2.Clone());
        }

        public void Dispose()
        {
            Statement1.Dispose();
            Statement2.Dispose();
        }
    }
}
