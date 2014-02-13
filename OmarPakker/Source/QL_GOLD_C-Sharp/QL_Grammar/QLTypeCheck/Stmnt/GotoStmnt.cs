
namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class GotoStmnt : QL_Grammar.QLAlgebra.Stmnt.GotoStmnt, ITypeCheckStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}
    }
}
