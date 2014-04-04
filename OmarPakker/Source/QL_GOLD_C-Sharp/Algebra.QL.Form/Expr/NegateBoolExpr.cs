using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class NegateBoolExpr : UnaryExpr<IFormExpr>, IFormExpr
    {
        private readonly IEvalExpr evalExpr;

        public NegateBoolExpr(IFormExpr expr, IEvalExpr eval)
            : base(expr)
        {
            evalExpr = eval;
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            return Expr1.BuildForm(env);
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return evalExpr.Evaluate(env);
        }
    }
}
