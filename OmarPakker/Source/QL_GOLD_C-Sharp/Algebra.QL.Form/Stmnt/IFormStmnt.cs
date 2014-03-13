using System;
using System.Windows;

namespace Algebra.QL.Form.Stmnt
{
    public interface IFormStmnt : IForm, IDisposable
    {
        FrameworkElement BuildForm();

        IFormStmnt Clone();
    }
}
