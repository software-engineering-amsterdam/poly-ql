using System;
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

        public Tuple<int, int> StatementSourcePosition { get; set; }

        public IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid()
        {
            return Body.CheckTypesValid();
        }
    }
}
