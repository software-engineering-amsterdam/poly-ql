
namespace Algebra.QL.Core.Stmnt
{
    public abstract class TextExprStmnt<E>
    {
        public string Text { get; private set; }
        public E Expression { get; private set; }

        public TextExprStmnt(string text, E expr)
        {
            Text = text;
            Expression = expr;
        }
    }
}
