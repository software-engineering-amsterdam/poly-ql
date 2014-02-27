using System;
using Algebra.QL.Core.Factory;

namespace Algebra.QL.Extensions.Factory
{
    public interface IQLExtensionsFactory<E, S, T> : IQLFactory<E, S, T>
    {
        T DateType();

		E Date(DateTime date);

        E Modulo(E l, E r);
        E Power(E l, E r);

		S Loop(E e, S s);
    }
}
