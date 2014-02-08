using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public interface ITypeCheckStmnt : IStmntNode
    {
        bool CheckTypesValid(out string msg);
    }
}
