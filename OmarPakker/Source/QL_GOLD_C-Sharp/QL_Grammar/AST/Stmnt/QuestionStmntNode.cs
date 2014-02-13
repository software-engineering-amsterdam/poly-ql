using System;
using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public abstract class QuestionStmntNode<E> : IStmntNode
        where E : IExprNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string QuestionText { get; private set; }
        public bool Editable { get; private set; }
        public E Expression { get; private set; }

        public QuestionStmntNode(string text, bool editable, E expr)
        {
            QuestionText = text;
            Editable = editable;
            Expression = expr;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is QuestionStmntNode<E>))
			{
				return false;
			}

			QuestionStmntNode<E> other = (QuestionStmntNode<E>)obj;
			return QuestionText.Equals(other.QuestionText) && Editable.Equals(other.Editable)
				&& Expression.Equals(other.Expression);
		}

		public override int GetHashCode()
		{
			return QuestionText.GetHashCode() + Editable.GetHashCode() + Expression.GetHashCode();
		}
    }
}
