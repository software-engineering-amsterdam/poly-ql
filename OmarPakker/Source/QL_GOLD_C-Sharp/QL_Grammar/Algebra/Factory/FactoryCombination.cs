using System;

namespace QL_Grammar.Algebra.Factory
{
	public abstract class FactoryCombination<E1, S1, E2, S2, F1, F2>
		: IFactory<Tuple<E1, E2>, Tuple<S1, S2>>
		where F1 : IFactory<E1, S1>
		where F2 : IFactory<E2, S2>
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
