
namespace QL_Grammar.AST.Expr
{
    public class SingleExprNode<E> : IExprNode
        where E : IExprNode
    {
        public E Expr1 { get; private set; }

        public SingleExprNode(E e1)
        {
            Expr1 = e1;
        }
    }
}
