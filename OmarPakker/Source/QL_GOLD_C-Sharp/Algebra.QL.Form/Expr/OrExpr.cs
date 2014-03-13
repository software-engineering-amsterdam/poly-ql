
namespace Algebra.QL.Form.Expr
{
    public class OrExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return (bool)Expr1.ExpressionValue || (bool)Expr2.ExpressionValue; }
            set { }
        }

		public OrExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}

        public override IFormExpr Clone()
        {
            return new OrExpr(Expr1.Clone(), Expr2.Clone());
        }
	}
}
