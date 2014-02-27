using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
{
    public class RealLiteral : LiteralExpr<double>, IPrintExpr
    {
        public override IPrintType Type { get { return new RealType(); } }

        public RealLiteral(double value)
            : base(value)
        {

        }
    }
}
