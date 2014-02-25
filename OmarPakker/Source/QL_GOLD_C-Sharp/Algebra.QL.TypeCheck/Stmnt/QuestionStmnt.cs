using System;
using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class QuestionStmnt : QuestionStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, bool editable, ITypeCheckExpr e)
            : base(text, editable, e)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
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
