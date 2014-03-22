using System.Windows;
using Algebra.Core.Type;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Type
{
    public interface IFormType : IForm, ITypeBase<IFormType>
    {
        IFormExpr DefaultValue { get; }

        void SetElementExpression(IFormExpr value);
        FrameworkElement BuildElement(VarEnvironment env, bool editable);
    }
}
