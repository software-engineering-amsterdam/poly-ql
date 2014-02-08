using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class CompStmnt : CompStmntNode<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public CompStmnt(params ITypeCheckStmnt[] stmnts)
            : base(stmnts)
        {

        }

        public bool CheckTypesValid(out string msg)
        {
            msg = null;
            return true;
        }
    }
}
