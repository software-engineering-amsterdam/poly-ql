using QL_Grammar.QLAlgebra.Factory;

namespace QL_ExtensionTest.QLAlgebraExtensions.Factory
{
    public interface IQLExtensionsFactory<E, S> : IQLStmntFactory<E, S>
    {
        E Modulo(E l, E r);
        E Power(E l, E r);

		S Loop(E e, S s);
    }
}
