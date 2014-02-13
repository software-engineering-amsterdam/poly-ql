
namespace QL_Grammar.QLAlgebra.Expr
{
    public abstract class TripleExpr<E> : DoubleExpr<E>
    {
        public E Expr3 { get; private set; }

        public TripleExpr(E e1, E e2, E e3)
            : base(e1, e2)
        {
            Expr3 = e3;
        }

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is TripleExpr<E>))
			{
				return false;
			}

			return Expr3.Equals(((TripleExpr<E>)obj).Expr3);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + Expr3.GetHashCode();
		}
    }
}
