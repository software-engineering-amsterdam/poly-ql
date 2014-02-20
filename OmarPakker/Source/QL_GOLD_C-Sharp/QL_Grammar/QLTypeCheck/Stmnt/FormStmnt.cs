using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class FormStmnt : FormStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }

        public void TypeCheck(TypeCheckData data)
        {
            data.Forms.Add(Name);
            data.Variables.Clear();

            Body.TypeCheck(data);
        }
    }
}
