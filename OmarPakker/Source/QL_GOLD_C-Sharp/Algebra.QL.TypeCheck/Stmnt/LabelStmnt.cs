using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

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

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            Expression.TypeCheck(env, errRep);

            if (String.IsNullOrWhiteSpace(Text))
            {
                errRep.ReportWarning(this, "Label has no text. Are you sure you only want it to show data?");
            }
        }
    }
}
