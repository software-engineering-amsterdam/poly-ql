using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, ITypeCheckExpr
    {
        public override ITypeCheckType Type { get { return new StringType(); } }

        public StringLiteral(string value)
            : base(value)
        {

        }
    }
}
