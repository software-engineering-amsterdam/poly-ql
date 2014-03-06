using System;

namespace Algebra.QL.Form.Expr
{
    public class SubtractExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Convert.ToDouble(Expr1.ExpressionValue) - Convert.ToDouble(Expr2.ExpressionValue); }
            set { }
        }

		public SubtractExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}
	}
}
