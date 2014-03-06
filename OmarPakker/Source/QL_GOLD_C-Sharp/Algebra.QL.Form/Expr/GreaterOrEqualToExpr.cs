using System;

namespace Algebra.QL.Form.Expr
{
    public class GreaterOrEqualToExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Convert.ToDouble(Expr1.ExpressionValue) >= Convert.ToDouble(Expr2.ExpressionValue); }
            set { }
        }

		public GreaterOrEqualToExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}
	}
}
