using System;

namespace Algebra.QL.Form.Expr
{
    public class GreaterThenExpr : BinaryExpr, IFormExpr
	{
        public override object ExpressionValue
        {
            get { return Convert.ToDouble(Expr1.ExpressionValue) > Convert.ToDouble(Expr2.ExpressionValue); }
            set { }
        }

		public GreaterThenExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
		{

		}

        public override IFormExpr Clone()
        {
            return new GreaterThenExpr(Expr1.Clone(), Expr2.Clone());
        }
	}
}
