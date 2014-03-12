using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, IFormExpr
    {
        public override IFormType Type { get { return new BoolType(); } }

        public override object ExpressionValue
        {
            set { base.ExpressionValue = System.Convert.ToBoolean(value); }
        }

        public BoolLiteral(bool value)
            : base(value)
        {

        }
    }
}
