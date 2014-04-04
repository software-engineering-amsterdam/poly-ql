using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, ITypeCheckExpr
    {
        public StringLiteral(string value)
            : base(value)
        {

        }

        public override ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            return new StringType();
        }
    }
}
