using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class RealLiteral : LiteralExpr<double>, ITypeCheckExpr
    {
        public override ITypeCheckType Type { get { return new RealType(); } }

        public RealLiteral(double value)
            : base(value)
        {

        }
    }
}
