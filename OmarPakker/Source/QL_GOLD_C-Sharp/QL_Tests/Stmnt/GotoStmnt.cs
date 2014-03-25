
namespace QL_Tests.Stmnt
{
    public class GotoStmnt : ITestStmnt
    {
        public GotoStmnt()
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is GotoStmnt))
            {
                return false;
            }

            return true;
        }

        public override int GetHashCode()
        {
            return typeof(GotoStmnt).GetHashCode();
        }
    }
}
