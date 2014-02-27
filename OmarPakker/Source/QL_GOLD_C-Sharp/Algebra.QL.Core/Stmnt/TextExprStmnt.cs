using System;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Stmnt
{
    public abstract class TextExprStmnt<E> : IStmntNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public string Text { get; private set; }
        public E Expression { get; private set; }

        public TextExprStmnt(string text, E expr)
        {
            Text = text;
            Expression = expr;
        }

        public override bool Equals(object obj)
        {
            if (!(obj is TextExprStmnt<E>))
            {
                return false;
            }

            TextExprStmnt<E> other = (TextExprStmnt<E>)obj;
            return Text.Equals(other.Text) && Expression.Equals(other.Expression);
        }

        public override int GetHashCode()
        {
            return Text.GetHashCode() + Expression.GetHashCode();
        }
    }
}
