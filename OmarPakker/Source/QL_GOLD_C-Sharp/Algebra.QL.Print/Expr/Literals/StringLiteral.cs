
namespace Algebra.QL.Print.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, IPrintExpr
    {
        public StringLiteral(string value)
            : base(value)
        {

        }
    }
}
