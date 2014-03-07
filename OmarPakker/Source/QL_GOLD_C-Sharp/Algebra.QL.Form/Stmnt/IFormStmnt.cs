using System.Windows;

namespace Algebra.QL.Form.Stmnt
{
    public interface IFormStmnt : IForm
    {
        FrameworkElement BuildForm();
    }
}
