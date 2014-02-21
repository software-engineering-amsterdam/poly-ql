using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Factory;

namespace QL_ExtensionTest.QLAlgebraExtensions.Factory
{
    public interface IQLExtensionsFactory<E, S> : IQLFactory<E, S>
    {
		IType DateType();
		E Date(DateTime date);

        E Modulo(E l, E r);
        E Power(E l, E r);

		S Loop(E e, S s);
    }
}
