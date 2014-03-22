
namespace Algebra.Core.Factory
{
    public abstract class FactoryUnion<S, E, T, F1, F2> : IStmntFactory<S, E, T>
		where F1 : IStmntFactory<S, E, T>
        where F2 : IStmntFactory<S, E, T>
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
