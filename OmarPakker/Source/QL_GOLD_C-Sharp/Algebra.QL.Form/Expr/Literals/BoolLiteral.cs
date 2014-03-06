using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, IFormExpr
    {
        public override IFormType Type { get { return new BoolType(); } }

        public BoolLiteral(bool value)
            : base(value)
        {

        }

        public override string ToString()
        {
            return base.ToString().ToLowerInvariant();
        }
    }
}
