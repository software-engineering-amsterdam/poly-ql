
namespace Algebra.QL.Print.Expr.Literals
{
    public class RealLiteral : LiteralExpr<double>, IPrintExpr
    {
        public RealLiteral(double value)
            : base(value)
        {

        }
    }
}
