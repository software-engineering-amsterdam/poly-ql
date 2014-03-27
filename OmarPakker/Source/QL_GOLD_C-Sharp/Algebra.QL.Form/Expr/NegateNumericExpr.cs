using Algebra.QL.Eval.Expr;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class NegateNumericExpr : NegateNumericExpr<IFormExpr>, IFormExpr
    {
        public NegateNumericExpr(IFormExpr expr)
            : base(expr)
        {
            
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return Expr1.BuildForm(env);
        }
    }
}
