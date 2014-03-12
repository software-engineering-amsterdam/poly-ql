using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public class FormStmnt : FormStmnt<IFormStmnt>, IFormStmnt
    {
        public FormStmnt(string name, IFormStmnt body)
            : base(name, body)
        {
            TypeEnvironment.Instance.ResetVariables();
        }

        public FrameworkElement BuildForm()
        {
            StackPanel sPanel = new StackPanel();
            sPanel.CanVerticallyScroll = true;
            sPanel.CanHorizontallyScroll = false;
            sPanel.Children.Add(Body.BuildForm());

            return new ScrollViewer() { Content = sPanel };
        }
    }
}
