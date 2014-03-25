using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public VarExpr(string name)
            : base(name)
        {

        }

        public ValueContainer BuildForm(VarEnvironment env)
        {
            return env.GetDeclared(Name);
        }
    }
}
