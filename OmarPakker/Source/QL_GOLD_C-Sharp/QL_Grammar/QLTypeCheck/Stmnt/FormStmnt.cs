using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class FormStmnt : FormStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }
    }
}
