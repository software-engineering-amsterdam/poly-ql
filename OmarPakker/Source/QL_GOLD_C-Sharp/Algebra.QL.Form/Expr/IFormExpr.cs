using Algebra.QL.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public interface IFormExpr : IForm, IEvalExpr
    {
        IFormType BuildForm(TypeEnvironment env);
    }
}
