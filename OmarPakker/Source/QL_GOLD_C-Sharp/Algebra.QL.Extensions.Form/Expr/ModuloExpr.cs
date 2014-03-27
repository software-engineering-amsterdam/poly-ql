using Algebra.QL.Extensions.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class ModuloExpr : ModuloExpr<IFormExpr>, IFormExpr
    {
        public ModuloExpr(IFormExpr l, IFormExpr r)
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
