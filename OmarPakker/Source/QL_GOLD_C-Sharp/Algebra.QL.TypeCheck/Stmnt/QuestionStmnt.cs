using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class QuestionStmnt : TextExprStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public QuestionStmnt(string text, ITypeCheckExpr e)
            : base(text, e)
        {

        }

        public void TypeCheck(TypeEnvironment env)
        {
            Expression.TypeCheck(env);

            if (String.IsNullOrWhiteSpace(Text))
            {
                env.ReportWarning("Empty question detected. Are you sure you want to leave this question blank?",
                    SourceStartPosition, SourceEndPosition);
            }
        }
    }
}
