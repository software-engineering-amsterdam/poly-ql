using System.Windows;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Form.Environment;

namespace Algebra.QL.Form.Stmnt
{
    public interface IFormStmnt : IForm
    {
        FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv);
    }
}
