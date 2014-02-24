using System;

namespace QL_Grammar.QLAlgebra.Stmnt
{
    public abstract class IfStmnt<E, S>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public E CheckExpression { get; private set; }
        public S IfTrueBody { get; private set; }

        public IfStmnt(E check, S ifTrue)
		{
			CheckExpression = check;
            IfTrueBody = ifTrue;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IfStmnt<E, S>))
			{
				return false;
			}

			IfStmnt<E, S> other = (IfStmnt<E, S>)obj;
			return CheckExpression.Equals(other.CheckExpression) && IfTrueBody.Equals(other.IfTrueBody);
		}

		public override int GetHashCode()
		{
			return CheckExpression.GetHashCode() + IfTrueBody.GetHashCode();
		}
    }
}
