using System;

namespace QL_Grammar.QLAlgebra.Expr
{
    public abstract class SingleExpr<E>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public E Expr1 { get; private set; }

        public SingleExpr(E e1)
        {
            Expr1 = e1;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is SingleExpr<E>))
			{
				return false;
			}

			return Expr1.Equals(((SingleExpr<E>)obj).Expr1);
		}

		public override int GetHashCode()
		{
			return Expr1.GetHashCode();
		}
    }
}
