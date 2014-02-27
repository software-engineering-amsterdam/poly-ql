
namespace QL_Tests.Stmnt
{
    public class GotoStmnt : Algebra.QL.Core.Stmnt.GotoStmnt, ITestStmnt
    {
		public GotoStmnt(string gotoName)
            : base(gotoName)
		{

		}

		public override bool Equals(object obj)
		{
			if (!(obj is GotoStmnt))
			{
				return false;
			}

			return GotoName.Equals(((GotoStmnt)obj).GotoName);
		}

		public override int GetHashCode()
		{
			return GotoName.GetHashCode();
		}
    }
}
