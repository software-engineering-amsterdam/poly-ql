using Algebra.Core.Helpers;

namespace Algebra.Core.Factory
{
    public abstract class FactoryCombination<S1, E1, T1, S2, E2, T2, F1, F2>
        : IStmntFactory<IPair<S1, S2>, IPair<E1, E2>, IPair<T1, T2>>
        where F1 : IStmntFactory<S1, E1, T1>
        where F2 : IStmntFactory<S2, E2, T2>
    {
        protected F1 Factory1 { get; private set; }
        protected F2 Factory2 { get; private set; }

        public FactoryCombination(F1 f1, F2 f2)
        {
            Factory1 = f1;
            Factory2 = f2;
        }
    }
}
