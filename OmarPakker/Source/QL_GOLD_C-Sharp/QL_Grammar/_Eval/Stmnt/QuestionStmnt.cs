using QL_Grammar.AST.Stmnt;
using QL_Grammar.Eval.Expr;

namespace QL_Grammar.Eval.Stmnt
{
    public class QuestionStmnt : QuestionStmntNode<IEvalExpr>, IEvalStmnt
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
