
namespace Algebra.Core.Expr
{
    public class TernaryExpr<E> : BinaryExpr<E>
    {
        public E Expr3 { get; private set; }

        public TernaryExpr(E e1, E e2, E e3)
            : base(e1, e2)
        {
            Expr3 = e3;
        }
    }
}
