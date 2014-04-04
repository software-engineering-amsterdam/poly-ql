
namespace Algebra.QL.Print.Expr.Literals
{
    public class IntLiteral : LiteralExpr<int>, IPrintExpr
    {
        public IntLiteral(int value)
            : base(value)
        {

        }
    }
}
