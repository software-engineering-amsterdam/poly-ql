using System.Windows;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
    public interface IFormStmnt : IForm
    {
        FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv);
    }
}
