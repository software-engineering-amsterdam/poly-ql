using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourcePosition { get; set; }

        public QuestionStmnt(string text, ITypeCheckExpr e)
            : base(text, e)
        {

        }

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            Expression.TypeCheck(env, errRep);

            if (String.IsNullOrWhiteSpace(Text))
            {
                errRep.ReportWarning("Empty question detected. Are you sure you want to leave this question blank?",
                    SourcePosition);
            }
        }
    }
}
