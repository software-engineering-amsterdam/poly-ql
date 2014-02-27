using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, IPrintExpr
    {
        public override IPrintType Type { get { return new StringType(); } }

        public StringLiteral(string value)
            : base(value)
        {

        }

        public override string ToString()
        {
            return "\"" + base.ToString() + "\"";
        }
    }
}
