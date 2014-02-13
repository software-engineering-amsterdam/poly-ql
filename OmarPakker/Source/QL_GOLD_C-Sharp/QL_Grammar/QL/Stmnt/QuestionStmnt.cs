using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
    public class QuestionStmnt : QuestionStmntNode<IExprNode>, IStmntNode
    {
        public QuestionStmnt(string text, bool editable, IExprNode e)
            : base(text, editable, e)
        {

        }
    }
}
