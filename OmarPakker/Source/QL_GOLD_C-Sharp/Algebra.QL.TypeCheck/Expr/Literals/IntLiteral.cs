using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class IntLiteral : LiteralExpr<int>, ITypeCheckExpr
    {
        public IntLiteral(int value)
            : base(value)
        {

        }

        public override ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            return new IntType();
        }
    }
}
