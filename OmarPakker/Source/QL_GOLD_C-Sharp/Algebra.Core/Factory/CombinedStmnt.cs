using Algebra.Core.Tree;

namespace Algebra.Core.Factory
{
    public sealed class CombinedStmnt<S1, S2> : CombinedItems<S1, S2>, IStmntNode
        where S1 : IStmntNode
        where S2 : IStmntNode
    {
        public CombinedStmnt(S1 s1, S2 s2)
            : base(s1, s2)
        {

        }
    }
}
