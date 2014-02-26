using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
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
