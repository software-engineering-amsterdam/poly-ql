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
            //TODO: Forms should not display at the same time but one at a time
            Grid g = new Grid();
            g.ShowGridLines = true;
            g.ColumnDefinitions.Add(new ColumnDefinition() { Width = new GridLength(0, GridUnitType.Auto) });
            g.ColumnDefinitions.Add(new ColumnDefinition() { Width = new GridLength(0, GridUnitType.Auto) });

            FrameworkElement el1 = Statement1.BuildForm();
            Grid.SetColumn(el1, 0);
            FrameworkElement el2 = Statement2.BuildForm();
            Grid.SetColumn(el2, 1);

            g.Children.Add(el1);
            g.Children.Add(el2);
            
            return g;
        }
    }
}
