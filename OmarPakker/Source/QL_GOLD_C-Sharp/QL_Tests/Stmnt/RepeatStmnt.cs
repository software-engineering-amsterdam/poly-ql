using Algebra.QL.Extensions.Stmnt;
using QL_Tests.Expr;

namespace QL_Tests.Stmnt
{
    public class RepeatStmnt : RepeatStmnt<ITestExpr, ITestStmnt>, ITestStmnt
    {
        public RepeatStmnt(ITestExpr expr, ITestStmnt body)
            : base(expr, body)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is RepeatStmnt))
            {
                return false;
            }

            RepeatStmnt other = (RepeatStmnt)obj;
            return Expression.Equals(other.Expression)
                && Body.Equals(other.Body);
        }

        public override int GetHashCode()
        {
            return Expression.GetHashCode() ^ Body.GetHashCode();
        }
    }
}
