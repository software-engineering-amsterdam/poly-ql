using Algebra.QL.Eval.Expr.Literals;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, IFormExpr
    {
        public BoolLiteral(bool value)
            : base(value)
        {

        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            return new BoolType();
        }
    }
}
