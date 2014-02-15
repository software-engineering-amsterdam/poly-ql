using System;

namespace QL_Grammar.QLAlgebra.Stmnt
{
    public abstract class QuestionStmnt<E>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string QuestionText { get; private set; }
        public bool Editable { get; private set; }
        public E Expression { get; private set; }

        public QuestionStmnt(string text, bool editable, E expr)
        {
            QuestionText = text;
            Editable = editable;
            Expression = expr;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is QuestionStmnt<E>))
			{
				return false;
			}

			QuestionStmnt<E> other = (QuestionStmnt<E>)obj;
			return QuestionText.Equals(other.QuestionText) && Editable.Equals(other.Editable)
				&& Expression.Equals(other.Expression);
		}

		public override int GetHashCode()
		{
			return QuestionText.GetHashCode() + Editable.GetHashCode() + Expression.GetHashCode();
		}
    }
}
