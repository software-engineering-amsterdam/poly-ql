
namespace QL_Grammar.AST.Expr
{
    public class DoubleExprNode<E> : SingleExprNode<E>
        where E : IExprNode
    {
        public E Expr2 { get; private set; }

        public DoubleExprNode(E e1, E e2)
            : base(e1)
        {
            Expr2 = e2;
        }
    }
}
