
namespace QL_Grammar.QLAlgebra.Expr
{
    public abstract class DoubleExpr<E> : SingleExpr<E>
    {
        public E Expr2 { get; private set; }

        public DoubleExpr(E e1, E e2)
            : base(e1)
        {
            Expr2 = e2;
        }

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is DoubleExpr<E>))
			{
				return false;
			}

			return Expr2.Equals(((DoubleExpr<E>)obj).Expr2);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + Expr2.GetHashCode();
		}
    }
}
