using System;

namespace Algebra.QL.Form.Expr
{
    public class LessOrEqualToExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Convert.ToDouble(Expr1.ExpressionValue) <= Convert.ToDouble(Expr2.ExpressionValue); }
            set { }
        }

		public LessOrEqualToExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}
	}
}
