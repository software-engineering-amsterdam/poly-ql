using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr : IForm
    {
        ValueContainer BuildForm(VarEnvironment env);
    }
}
