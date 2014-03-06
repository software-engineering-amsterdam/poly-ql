using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, IFormExpr
    {
        public override IFormType Type { get { return new StringType(); } }

        public StringLiteral(string value)
            : base(value)
        {

        }
    }
}
