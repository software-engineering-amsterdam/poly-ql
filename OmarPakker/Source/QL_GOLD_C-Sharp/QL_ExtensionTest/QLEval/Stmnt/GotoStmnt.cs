
namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class GotoStmnt : QL_Grammar.QLAlgebra.Stmnt.GotoStmnt, IEvalStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{

		}

        public void Eval()
        {
            
        }
    }
}
