using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr : IForm
    {
        ValueContainer Evaluate(ValueEnvironment env);

        IFormType BuildForm(TypeEnvironment env);
    }
}
