
namespace QL_Grammar.AST.Expr
{
    public class SingleExprNode<E> : IExprNode
        where E : IExprNode
    {
        public E Expression { get; private set; }

        public SingleExprNode(E e)
        {
            Expression = e;
        }
    }
}
