
namespace QL_Grammar.AST.Expr
{
    public class TripleExprNode<E> : DoubleExprNode<E>
        where E : IExprNode
    {
        public E Expr3 { get; private set; }

        public TripleExprNode(E e1, E e2, E e3)
            : base(e1, e2)
        {
            Expr3 = e3;
        }
    }
}
