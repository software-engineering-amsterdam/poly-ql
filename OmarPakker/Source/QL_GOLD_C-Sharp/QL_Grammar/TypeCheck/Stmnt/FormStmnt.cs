using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class FormStmnt : FormStmntNode<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }

        public bool CheckTypesValid(out string msg)
        {
            msg = null;
            return true;
        }
    }
}
