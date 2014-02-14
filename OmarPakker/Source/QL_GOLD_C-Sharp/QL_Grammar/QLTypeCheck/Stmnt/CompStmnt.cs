using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class CompStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public CompStmnt(params ITypeCheckStmnt[] stmnts)
            : base(stmnts)
        {

        }

        public void TypeCheck(TypeCheckData data)
        {
            foreach (ITypeCheckStmnt item in Statements)
            {
                item.TypeCheck(data);
            }
        }
    }
}
