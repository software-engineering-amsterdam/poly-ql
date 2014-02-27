using Algebra.QL.Extensions.Stmnt;
using QL_Tests.Expr;

namespace QL_Tests.Stmnt
{
    public class LoopStmnt : LoopStmnt<ITestExpr, ITestStmnt>, ITestStmnt
    {
        public LoopStmnt(ITestExpr expr, ITestStmnt body)
            : base(expr, body)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is LoopStmnt))
            {
                return false;
            }

            LoopStmnt other = (LoopStmnt)obj;
            return Expression.Equals(other.Expression)
                && Body.Equals(other.Body);
        }

        public override int GetHashCode()
        {
            return Expression.GetHashCode() ^ Body.GetHashCode();
        }
    }
}
