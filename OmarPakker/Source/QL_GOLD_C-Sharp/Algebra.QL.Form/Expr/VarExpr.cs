using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarExpr : QL.Eval.Expr.VarExpr, IFormExpr
    {
        public VarExpr(string name)
            : base(name)
        {

        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return env.GetDeclared(Name);
        }
    }
}
