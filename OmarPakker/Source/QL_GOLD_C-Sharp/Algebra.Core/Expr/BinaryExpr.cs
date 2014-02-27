
namespace Algebra.Core.Expr
{
    public abstract class BinaryExpr<E> : UnaryExpr<E>
    {
        public E Expr2 { get; private set; }

        public BinaryExpr(E e1, E e2)
            : base(e1)
        {
            Expr2 = e2;
        }
    }
}
