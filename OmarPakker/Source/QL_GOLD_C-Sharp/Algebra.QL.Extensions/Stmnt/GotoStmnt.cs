
namespace Algebra.QL.Extensions.Stmnt
{
    public abstract class GotoStmnt
    {
        public string GotoName { get; private set; }

		public GotoStmnt(string gotoName)
		{
            GotoName = gotoName;
		}
    }
}
