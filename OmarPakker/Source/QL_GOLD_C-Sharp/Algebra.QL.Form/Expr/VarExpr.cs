using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Form.Expr
{
    public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public VarExpr(string name)
            : base(name)
        {

        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            return env.GetDeclared(Name);
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return env.GetDeclared(Name);
        }
    }
}
