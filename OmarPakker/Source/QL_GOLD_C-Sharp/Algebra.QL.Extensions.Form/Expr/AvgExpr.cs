using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class AvgExpr : Eval.Expr.AvgExpr, IFormExpr
    {
        public AvgExpr(string name)
            : base(name)
        {
            
        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            return new RealType();
        }
    }
}
