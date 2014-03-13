using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class StringLiteral : LiteralExpr<string>, IFormExpr
    {
        public override IFormType Type { get { return new StringType(); } }

        public override object ExpressionValue
        {
            set { base.ExpressionValue = System.Convert.ToString(value); }
        }

        public StringLiteral(string value)
            : base(value)
        {

        }
        
        public override IFormExpr Clone()
        {
            return new StringLiteral(Value);
        }
    }
}
