using Algebra.QL.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : IfElseExpr<IFormExpr>, IFormExpr
    {
        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
            : base(a, b, c)
        {
            
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            IFormType a = Expr2.BuildForm(env);
            IFormType b = Expr3.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }
    }
}
