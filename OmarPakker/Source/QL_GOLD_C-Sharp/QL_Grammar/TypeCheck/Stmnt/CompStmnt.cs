using System;
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

        public Tuple<int, int> StatementSourcePosition { get; set; }

        public IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid()
        {
            foreach (ITypeCheckStmnt stmnt in Statements)
            {
                //Flatten errors
                var errors = stmnt.CheckTypesValid();

                if(errors == null)
                {
                    continue;
                }

                foreach (var error in errors)
                {
                    yield return error;
                }
            }
        }
    }
}
