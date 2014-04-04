using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class RealLiteral : LiteralExpr<double>, ITypeCheckExpr
    {
        public RealLiteral(double value)
            : base(value)
        {

        }

        public override ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            return new RealType();
        }
    }
}
