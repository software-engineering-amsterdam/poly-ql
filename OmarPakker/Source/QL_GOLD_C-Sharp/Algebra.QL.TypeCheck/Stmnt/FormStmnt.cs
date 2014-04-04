using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class FormStmnt : FormStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }

        public void TypeCheck(ITypeEnvironment env)
        {
            env.Clear();

            Body.TypeCheck(env);
        }
    }
}
