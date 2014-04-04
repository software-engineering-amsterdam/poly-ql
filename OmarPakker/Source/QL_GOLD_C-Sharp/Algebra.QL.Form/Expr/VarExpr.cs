using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        private readonly IEvalExpr evalExpr;

        public VarExpr(string name, IEvalExpr eval)
            : base(name)
        {
            evalExpr = eval;
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            return env.GetDeclared(Name);
        }

        public ValueContainer Evaluate(IValueEnvironment env)
        {
            return evalExpr.Evaluate(env);
        }
    }
}
