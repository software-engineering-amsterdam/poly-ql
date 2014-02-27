using System;
using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, ITypeCheckExpr e)
            : base(text, e)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            Expression.TypeCheck(data);

            if (String.IsNullOrWhiteSpace(Text))
            {
                data.ReportWarning("Empty question detected. Are you sure you want to leave this question blank?",
                    SourcePosition);
            }

            if (queue.Count > 0) queue.Dequeue().TypeCheck(queue, data);
        }
    }
}
