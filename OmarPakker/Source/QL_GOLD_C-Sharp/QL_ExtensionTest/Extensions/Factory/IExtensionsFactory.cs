using QL_Grammar.QLAlgebra.Factory;

namespace QL_ExtensionTest.Extensions.Factory
{
    public interface IExtensionsFactory<E, S> : IQLStmntFactory<E, S>
    {
        E Modulo(E l, E r);
        E Power(E l, E r);

		S Loop(E e, S s);
    }
}
