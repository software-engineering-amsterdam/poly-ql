
namespace QL_Grammar.AST.Stmnt
{
    public class GotoStmntNode : IStmntNode
    {
        public string GotoName { get; private set; }

		public GotoStmntNode(string gotoName)
		{
            GotoName = gotoName;
		}
    }
}
