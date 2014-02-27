using Algebra.Core.Tree;

namespace Algebra.Core.Expr
{
    public abstract class BinaryExpr<E> : UnaryExpr<E>
        where E : IExprNode
    {
        public E Expr2 { get; private set; }

        public BinaryExpr(E e1, E e2)
            : base(e1)
        {
            Expr2 = e2;
        }

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is BinaryExpr<E>))
			{
				return false;
			}

			return Expr2.Equals(((BinaryExpr<E>)obj).Expr2);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + Expr2.GetHashCode();
		}
    }
}
