using System;
using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class QuestionStmnt : QuestionStmntNode<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, bool editable, ITypeCheckExpr e)
            : base(text, editable, e)
        {

        }

        public Tuple<int, int> StatementSourcePosition { get; set; }

        public IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid()
        {
            return null;
        }
    }
}
