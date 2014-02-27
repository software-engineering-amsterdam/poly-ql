using Algebra.Core.Tree;

namespace Algebra.Core.Factory
{
    public sealed class CombinedExpr<E1, E2> : CombinedItems<E1, E2>, IExprNode
        where E1 : IExprNode
        where E2 : IExprNode
    {
        public CombinedExpr(E1 e1, E2 e2)
            : base(e1, e2)
        {

        }
    }
}
