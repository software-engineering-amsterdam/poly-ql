using Algebra.QL.Core.Stmnt;
using QL_Tests.Expr;

namespace QL_Tests.Stmnt
{
    public class IfStmnt : IfStmnt<ITestExpr, ITestStmnt>, ITestStmnt
    {
        public IfStmnt(ITestExpr check, ITestStmnt ifTrue)
            : base(check, ifTrue)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is IfStmnt))
            {
                return false;
            }

            IfStmnt other = (IfStmnt)obj;
            return CheckExpression.Equals(other.CheckExpression) && IfTrueBody.Equals(other.IfTrueBody);
        }

        public override int GetHashCode()
        {
            return CheckExpression.GetHashCode() ^ IfTrueBody.GetHashCode();
        }
    }
}
