using System.Windows;
using Algebra.Core.Type;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Type
{
    public interface IFormType : IForm, ITypeBase<IFormType>
    {
        IFormExpr DefaultValue { get; }

        FrameworkElement BuildElement(IFormExpr value, object initialValue, bool editable);
    }
}
