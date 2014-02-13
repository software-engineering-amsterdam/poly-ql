using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class CompStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public CompStmnt(params ITypeCheckStmnt[] stmnts)
            : base(stmnts)
        {

        }
    }
}
