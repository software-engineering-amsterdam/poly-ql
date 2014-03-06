using System.Windows;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Type
{
    public interface IFormType
    {
        IFormExpr DefaultValue { get; }

        FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable);
    }
}
