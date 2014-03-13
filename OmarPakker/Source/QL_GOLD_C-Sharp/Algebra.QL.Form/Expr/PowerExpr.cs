using System;

namespace Algebra.QL.Form.Expr
{
    public class PowerExpr : BinaryExpr, IFormExpr
    {
        public override object ExpressionValue
        {
            get { return Math.Pow(Convert.ToDouble(Expr1.ExpressionValue), Convert.ToDouble(Expr2.ExpressionValue)); }
            set { }
        }

        public PowerExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {

        }

        public override IFormExpr Clone()
        {
            return new PowerExpr(Expr1.Clone(), Expr2.Clone());
        }
    }
}
