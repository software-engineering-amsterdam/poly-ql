using Algebra.Core.Expr;

namespace QL_Tests.Expr
{
	public class UnaryExpr : UnaryExpr<ITestExpr>, ITestExpr
	{
        public UnaryExpr(ITestExpr e)
            : base(e)
		{

		}

        public override bool Equals(object obj)
        {
            if (!(obj is UnaryExpr))
            {
                return false;
            }

            return Expr1.Equals(((UnaryExpr)obj).Expr1);
        }

        public override int GetHashCode()
        {
            return Expr1.GetHashCode();
        }
	}
}
