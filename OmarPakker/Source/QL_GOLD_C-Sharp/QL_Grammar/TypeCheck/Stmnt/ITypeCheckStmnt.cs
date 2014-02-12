using System;
using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public interface ITypeCheckStmnt : IStmntNode
    {
        Tuple<int, int> StatementSourcePosition { set; }

        IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid();
    }
}
