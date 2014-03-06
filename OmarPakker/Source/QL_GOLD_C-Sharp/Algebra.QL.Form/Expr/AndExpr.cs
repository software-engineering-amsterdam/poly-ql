
namespace Algebra.QL.Form.Expr
{
    public class AndExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return (bool)Expr1.ExpressionValue && (bool)Expr2.ExpressionValue; }
            set { }
        }

        public AndExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }
	}
}
