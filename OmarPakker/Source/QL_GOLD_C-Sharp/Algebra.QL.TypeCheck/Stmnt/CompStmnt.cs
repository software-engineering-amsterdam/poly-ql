using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
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
