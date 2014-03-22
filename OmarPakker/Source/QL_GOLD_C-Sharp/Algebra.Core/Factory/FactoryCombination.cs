using Algebra.Core.Helpers;

namespace Algebra.Core.Factory
{
	public abstract class FactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>
        : IFactory<IPair<E1, E2>, IPair<S1, S2>, IPair<T1, T2>>
		where F1 : IFactory<E1, S1, T1>
		where F2 : IFactory<E2, S2, T2>
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
