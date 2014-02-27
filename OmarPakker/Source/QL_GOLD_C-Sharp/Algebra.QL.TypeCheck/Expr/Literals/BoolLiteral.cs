using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, ITypeCheckExpr
    {
        public override ITypeCheckType Type { get { return new BoolType(); } }

        public BoolLiteral(bool value)
            : base(value)
        {

        }
    }
}
