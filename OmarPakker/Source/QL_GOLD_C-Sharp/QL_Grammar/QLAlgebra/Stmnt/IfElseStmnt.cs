
namespace QL_Grammar.QLAlgebra.Stmnt
{
    public abstract class IfElseStmnt<E, S> : IfStmnt<E, S>
	{
        public S IfFalseBody { get; private set; }

        public IfElseStmnt(E check, S ifTrue, S ifFalse)
            : base(check, ifTrue)
		{
            IfFalseBody = ifFalse;
		}

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is IfElseStmnt<E, S>))
			{
				return false;
			}

			return IfFalseBody.Equals(((IfElseStmnt<E, S>)obj).IfFalseBody);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + IfFalseBody.GetHashCode();
		}
	}
}
