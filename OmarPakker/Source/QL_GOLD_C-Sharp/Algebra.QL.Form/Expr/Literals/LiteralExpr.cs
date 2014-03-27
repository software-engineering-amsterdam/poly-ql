using Algebra.QL.Eval.Expr.Literals;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<IFormType, V>, IFormExpr
    {
        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return Type;
        }
    }
}
