using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : TernaryExpr<IFormExpr>, IFormExpr
    {
        private readonly IEvalExpr evalExpr;

        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c, IEvalExpr eval)
            : base(a, b, c)
        {
            evalExpr = eval;
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            IFormType a = Expr2.BuildForm(env);
            IFormType b = Expr3.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return evalExpr.Evaluate(env);
        }
    }
}
