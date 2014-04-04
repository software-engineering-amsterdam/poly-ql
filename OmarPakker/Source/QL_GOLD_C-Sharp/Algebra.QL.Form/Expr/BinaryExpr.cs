using Algebra.Core.Expr;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class BinaryExpr : BinaryExpr<IFormExpr>, IFormExpr
    {
        private readonly IEvalExpr evalExpr;

        public BinaryExpr(IFormExpr l, IFormExpr r, IEvalExpr eval)
            : base(l, r)
        {
            evalExpr = eval;
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            IFormType a = Expr1.BuildForm(env);
            IFormType b = Expr2.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return evalExpr.Evaluate(env);
        }
    }
}
