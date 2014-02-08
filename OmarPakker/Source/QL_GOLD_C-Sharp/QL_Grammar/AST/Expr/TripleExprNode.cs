
namespace QL_Grammar.AST.Expr
{
    public class TripleExprNode<E> : IExprNode
        where E : IExprNode
    {
        public E ExprA { get; private set; }
        public E ExprB { get; private set; }
        public E ExprC { get; private set; }

        public TripleExprNode(E a, E b, E c)
        {
            ExprA = a;
            ExprB = b;
            ExprC = c;
        }
    }
}
