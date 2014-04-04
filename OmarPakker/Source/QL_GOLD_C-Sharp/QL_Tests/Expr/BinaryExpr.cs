using Algebra.Core.Expr;

namespace QL_Tests.Expr
{
    public class BinaryExpr : BinaryExpr<ITestExpr>, ITestExpr
    {
        public BinaryExpr(ITestExpr l, ITestExpr r)
            : base(l, r)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is BinaryExpr))
            {
                return false;
            }

            BinaryExpr other = (BinaryExpr)obj;

            return Expr1.Equals(other.Expr1) && Expr2.Equals(other.Expr2);
        }

        public override int GetHashCode()
        {
            return Expr1.GetHashCode() ^ Expr2.GetHashCode();
        }
    }
}
