
namespace QL_Grammar.AST.Expr
{
    public abstract class TripleExprNode<E> : DoubleExprNode<E>
        where E : IExprNode
    {
        public E Expr3 { get; private set; }

        public TripleExprNode(E e1, E e2, E e3)
            : base(e1, e2)
        {
            Expr3 = e3;
        }

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is TripleExprNode<E>))
			{
				return false;
			}

			return Expr3.Equals(((TripleExprNode<E>)obj).Expr3);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode() + Expr3.GetHashCode();
		}
    }
}
