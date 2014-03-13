
namespace Algebra.QL.Form.Expr
{
    public class NotEqualExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return !Expr1.ExpressionValue.Equals(Expr2.ExpressionValue); }
            set { }
        }

		public NotEqualExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}

        public override IFormExpr Clone()
        {
            return new NotEqualExpr(Expr1.Clone(), Expr2.Clone());
        }
	}
}
