
namespace Algebra.QL.Form.Expr
{
    public class EqualsExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Expr1.ExpressionValue.Equals(Expr2.ExpressionValue); }
            set { }
        }

		public EqualsExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}
	}
}
