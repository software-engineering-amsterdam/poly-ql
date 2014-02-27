using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class FormStmnt : FormStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourcePosition { get; set; }

		public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            env.DeclareForm(Name);

            Body.TypeCheck(env, errRep);

            env.ResetGotos();
            env.ResetVariables();
        }
    }
}
