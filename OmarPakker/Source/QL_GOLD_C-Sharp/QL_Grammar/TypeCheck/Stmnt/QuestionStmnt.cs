using QL_Grammar.AST.Stmnt;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class QuestionStmnt : QuestionStmntNode<ITypeCheckExpr>, ITypeCheckStmnt
    {
        public QuestionStmnt(string text, bool editable, ITypeCheckExpr e)
            : base(text, editable, e)
        {

        }

        public bool CheckTypesValid(out string msg)
        {
            msg = null;
            return true;
        }
    }
}
