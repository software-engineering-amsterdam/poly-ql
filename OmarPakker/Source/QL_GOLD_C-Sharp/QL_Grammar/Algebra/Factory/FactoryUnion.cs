
namespace QL_Grammar.Algebra.Factory
{
	public abstract class FactoryUnion<E, S, F1, F2> : IFactory<E, S>
		where F1 : IFactory<E, S>
		where F2 : IFactory<E, S>
	{
		protected F1 Factory1 { get; private set; }
		protected F2 Factory2 { get; private set; }

		public FactoryUnion(F1 f1, F2 f2)
		{
			Factory1 = f1;
			Factory2 = f2;
		}
	}
}
