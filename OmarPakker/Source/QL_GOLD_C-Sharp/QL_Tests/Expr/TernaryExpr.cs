using Algebra.Core.Expr;

namespace QL_Tests.Expr
{
    public class TernaryExpr : TernaryExpr<ITestExpr>, ITestExpr
    {
        public TernaryExpr(ITestExpr a, ITestExpr b, ITestExpr c)
            : base(a, b, c)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is TernaryExpr))
            {
                return false;
            }

            TernaryExpr other = (TernaryExpr)obj;

            return Expr1.Equals(other.Expr1) && Expr2.Equals(other.Expr2) && Expr3.Equals(other.Expr3);
        }

        public override int GetHashCode()
        {
            return Expr1.GetHashCode() ^ Expr2.GetHashCode() ^ Expr3.GetHashCode();
        }
    }
}
