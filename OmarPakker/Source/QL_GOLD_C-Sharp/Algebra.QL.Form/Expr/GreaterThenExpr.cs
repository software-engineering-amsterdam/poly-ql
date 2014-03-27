using Algebra.QL.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class GreaterThenExpr : GreaterThenExpr<IFormExpr>, IFormExpr
    {
        public GreaterThenExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            IFormType a = Expr1.BuildForm(env);
            IFormType b = Expr2.BuildForm(env);
            IFormType type = a.GetLeastUpperBound(b);

            return type;
        }
    }
}
