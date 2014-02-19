using QL_ExtensionTest.QLEval.Expr;
using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class QuestionStmnt : QuestionStmnt<IEvalExpr>, IEvalStmnt
    {
        public QuestionStmnt(string text, bool editable, IEvalExpr e)
            : base(text, editable, e)
        {

        }

        public void Eval()
        {
            Expression.Eval();
        }
    }
}
