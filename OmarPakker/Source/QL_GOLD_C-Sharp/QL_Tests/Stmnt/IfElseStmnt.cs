using Algebra.QL.Core.Stmnt;
using QL_Tests.Expr;

namespace QL_Tests.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<ITestExpr, ITestStmnt>, ITestStmnt
	{
        public IfElseStmnt(ITestExpr check, ITestStmnt ifTrue, ITestStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

		public override bool Equals(object obj)
		{
			if (!(obj is IfElseStmnt))
			{
				return false;
			}

            IfElseStmnt other = (IfElseStmnt)obj;

			return CheckExpression.Equals(other.CheckExpression)
                && IfTrueBody.Equals(other.IfTrueBody)
                && IfFalseBody.Equals(other.IfFalseBody);
		}

		public override int GetHashCode()
		{
			return CheckExpression.GetHashCode() ^ IfTrueBody.GetHashCode() ^ IfFalseBody.GetHashCode();
		}
	}
}
