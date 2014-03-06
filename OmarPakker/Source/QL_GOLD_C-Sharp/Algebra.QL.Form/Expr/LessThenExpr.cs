using System;

namespace Algebra.QL.Form.Expr
{
    public class LessThenExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Convert.ToDouble(Expr1.ExpressionValue) < Convert.ToDouble(Expr2.ExpressionValue); }
            set { }
        }

		public LessThenExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}
	}
}
