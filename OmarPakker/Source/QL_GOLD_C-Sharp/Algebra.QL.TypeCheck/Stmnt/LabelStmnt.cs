using System;
using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class LabelStmnt : TextExprStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public LabelStmnt(string text, ITypeCheckExpr e)
            : base(text, e)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            Expression.TypeCheck(data);

            if (String.IsNullOrWhiteSpace(Text))
            {
                data.ReportWarning("Label has no text. Are you sure you only want it to show the value?",
                    SourcePosition);
            }

            if (queue.Count > 0) queue.Dequeue().TypeCheck(queue, data);
        }
    }
}
