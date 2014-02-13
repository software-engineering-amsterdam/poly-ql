
namespace QL_Grammar.AST.Expr
{
    public abstract class DoubleExprNode<E> : SingleExprNode<E>
        where E : IExprNode
    {
        public E Expr2 { get; private set; }

        public DoubleExprNode(E e1, E e2)
            : base(e1)
        {
            Expr2 = e2;
        }

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is DoubleExprNode<E>))
			{
				return false;
			}

			return Expr2.Equals(((DoubleExprNode<E>)obj).Expr2);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + Expr2.GetHashCode();
		}
    }
}
