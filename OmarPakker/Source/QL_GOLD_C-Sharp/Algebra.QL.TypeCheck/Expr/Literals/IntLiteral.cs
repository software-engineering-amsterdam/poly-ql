using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr.Literals
{
    public class IntLiteral : LiteralExpr<int>, ITypeCheckExpr
    {
        public override ITypeCheckType Type { get { return new IntType(); } }

        public IntLiteral(int value)
            : base(value)
        {

        }
    }
}
