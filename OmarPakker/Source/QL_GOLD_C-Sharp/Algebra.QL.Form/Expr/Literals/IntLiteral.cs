using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class IntLiteral : LiteralExpr<int>, IFormExpr
    {
        public override IFormType Type { get { return new IntType(); } }

        public IntLiteral(int value)
            : base(value)
        {

        }
    }
}
