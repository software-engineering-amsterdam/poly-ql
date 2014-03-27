using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Eval.Expr
{
    public class VarExpr : Algebra.Core.Expr.VarExpr, IEvalExpr
    {
        public VarExpr(string name)
            : base(name)
        {

        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            return env.GetDeclared(Name);
        }
    }
}
