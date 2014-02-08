using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public class QuestionStmntNode<E> : IStmntNode
        where E : IExprNode
    {
        public string QuestionText { get; private set; }
        public bool Editable { get; private set; }
        public E Expression { get; private set; }

        public QuestionStmntNode(string text, bool editable, E expr)
        {
            QuestionText = text;
            Editable = editable;
            Expression = expr;
        }
    }
}
