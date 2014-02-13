using System;

namespace QL_Grammar.Algebra.Factory
{
	public abstract class FactoryCombination<F1E, F1S, F2E, F2S, F1, F2> : IStmntFactory<Tuple<F1E, F2E>, Tuple<F1S, F2S>>
		where F1 : IStmntFactory<F1E, F1S>
		where F2 : IStmntFactory<F2E, F2S>
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
