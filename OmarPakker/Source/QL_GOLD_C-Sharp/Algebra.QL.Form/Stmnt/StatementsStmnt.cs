using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Form.Stmnt
{
    public class StatementsStmnt : CompStmnt<IFormStmnt>, IFormStmnt
    {
        public StatementsStmnt(IFormStmnt a, IFormStmnt b)
            : base(a, b)
        {

        }

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();
            sp.Children.Add(Statement1.BuildForm());
            sp.Children.Add(Statement2.BuildForm());
            return sp;
        }
    }
}
