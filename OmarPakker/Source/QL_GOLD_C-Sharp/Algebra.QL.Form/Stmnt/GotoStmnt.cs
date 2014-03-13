using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;

namespace Algebra.QL.Form.Stmnt
{
    public class GotoStmnt : IFormStmnt
    {
        public GotoStmnt()
		{

		}

        public FrameworkElement BuildForm()
        {
            Button b = new Button() { Width = 200, Content = "Next" };

            RoutedEventHandler onClick = (s, e) =>
            {
                for (FrameworkElement fe = (FrameworkElement)b.Parent; fe != null; fe = (FrameworkElement)fe.Parent)
                {
                    if (fe is Selector)
                    {
                        ((Selector)fe).SelectedIndex++;
                        break;
                    }
                }
            };
            b.Loaded += (s, e) => b.Click += onClick;
            b.Unloaded += (s, e) => b.Click -= onClick;

            return b;
        }

        public IFormStmnt Clone()
        {
            return new GotoStmnt();
        }

        public void Dispose()
        {

        }
    }
}
