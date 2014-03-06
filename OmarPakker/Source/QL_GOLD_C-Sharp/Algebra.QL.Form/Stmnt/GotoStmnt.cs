using System.Windows;
using System.Windows.Controls;

namespace Algebra.QL.Form.Stmnt
{
    public class GotoStmnt : Algebra.QL.Extensions.Stmnt.GotoStmnt, IFormStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{

		}

        public FrameworkElement BuildForm()
        {
            //TODO: Implement Goto
            return new Button() { Content = GotoName };
        }
    }
}
