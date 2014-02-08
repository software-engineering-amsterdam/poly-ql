
namespace QL_Grammar.AST.Expr
{
    public class DoubleExprNode<E> : IExprNode
        where E : IExprNode
    {
        public E Left { get; private set; }
        public E Right { get; private set; }

        public DoubleExprNode(E l, E r)
        {
            Left = l;
            Right = r;
        }
    }
}
