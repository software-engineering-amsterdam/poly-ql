using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public class GotoStmnt : IFormStmnt
    {
        public GotoStmnt()
		{

		}

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            Button b = new Button() { Width = 200, Content = "Next" };

            b.Click += (s, e) =>
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

            return b;
        }
    }
}
