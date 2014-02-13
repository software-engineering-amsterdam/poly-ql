using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Expr;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
    public class QuestionStmnt : QuestionStmnt<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, bool editable, ITypeCheckExpr e)
            : base(text, editable, e)
        {

        }
    }
}
