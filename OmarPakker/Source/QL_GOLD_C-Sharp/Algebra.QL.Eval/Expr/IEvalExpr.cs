using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public interface IEvalExpr : IEval
    {
        ValueContainer Evaluate(IValueEnvironment env);
    }
}
