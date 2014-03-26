using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Environment;

namespace Algebra.QL.Form.Stmnt
{
    public class FormStmnt : FormStmnt<IFormStmnt>, IFormStmnt
    {
        public FormStmnt(string name, IFormStmnt body)
            : base(name, body)
        {

        }

        public FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv)
        {
            vEnv.Clear();
            tEnv.Clear();

            StackPanel sPanel = new StackPanel();
            sPanel.CanVerticallyScroll = true;
            sPanel.CanHorizontallyScroll = false;
            sPanel.Children.Add(Body.BuildForm(vEnv, tEnv));

            return new ScrollViewer() { Content = sPanel };
        }
    }
}
