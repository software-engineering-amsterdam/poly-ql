using System;
using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
    public class QuestionStmnt : QuestionStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, bool editable, ITypeCheckExpr e)
            : base(text, editable, e)
        {

        }

        public void TypeCheck(TypeCheckData data)
        {
            Expression.TypeCheck(data);

            if (String.IsNullOrWhiteSpace(QuestionText))
            {
                data.ReportWarning("Empty question detected. Are you sure you want to leave this question blank?",
                    SourcePosition);
            }
        }
    }
}
