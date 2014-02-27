
namespace Algebra.Core.Expr
{
    public abstract class UnaryExpr<E>
    {
        public E Expr1 { get; private set; }

        public UnaryExpr(E e1)
        {
            Expr1 = e1;
        }
    }
}
