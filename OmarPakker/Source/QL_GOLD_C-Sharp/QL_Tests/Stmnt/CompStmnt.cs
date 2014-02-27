using Algebra.QL.Core.Stmnt;

namespace QL_Tests.Stmnt
{
    public class CompStmnt : CompStmnt<ITestStmnt>, ITestStmnt
    {
        public CompStmnt(ITestStmnt a, ITestStmnt b)
            : base(a, b)
        {

        }

		public override bool Equals(object obj)
		{
			if (!(obj is CompStmnt))
			{
				return false;
			}

			CompStmnt other = (CompStmnt)obj;
            return Statement1.Equals(other.Statement1) && Statement2.Equals(other.Statement2);
		}

		public override int GetHashCode()
		{
            return Statement1.GetHashCode() ^ Statement2.GetHashCode();
		}
    }
}
