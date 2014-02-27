using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
{
    public class IntLiteral : LiteralExpr<int>, IPrintExpr
    {
        public override IPrintType Type { get { return new IntType(); } }

        public IntLiteral(int value)
            : base(value)
        {

        }
    }
}
