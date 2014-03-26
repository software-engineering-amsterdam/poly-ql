using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class LabelStmnt : TextExprStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public LabelStmnt(string text, ITypeCheckExpr e)
            : base(text, e)
        {

        }

        public void TypeCheck(TypeEnvironment env)
        {
            Expression.TypeCheck(env);

            if (String.IsNullOrWhiteSpace(Text))
            {
                env.ReportWarning("Label has no text. Are you sure you only want it to show data?",
                    SourceStartPosition, SourceEndPosition);
            }
        }
    }
}
