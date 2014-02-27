using Algebra.Core.Tree;

namespace Algebra.Core.Factory
{
    public sealed class CombinedType<T1, T2> : CombinedItems<T1, T2>, ITypeNode
        where T1 : ITypeNode
        where T2 : ITypeNode
    {
        public CombinedType(T1 t1, T2 t2)
            : base(t1, t2)
        {

        }
    }
}
