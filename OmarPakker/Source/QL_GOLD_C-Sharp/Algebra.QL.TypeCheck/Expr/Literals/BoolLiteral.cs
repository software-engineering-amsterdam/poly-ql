using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, ITypeCheckExpr
    {
        public BoolLiteral(bool value)
            : base(value)
        {

        }

        public override ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            return new BoolType();
        }
    }
}
