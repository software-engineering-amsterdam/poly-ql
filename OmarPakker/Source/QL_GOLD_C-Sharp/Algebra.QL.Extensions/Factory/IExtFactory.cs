using System;

namespace Algebra.QL.Extensions.Factory
{
    public interface IExtFactory<E, S, T> : Algebra.QL.Core.Factory.IFactory<E, S, T>
    {
        T DateType();

		E Date(DateTime date);

        E Modulo(E l, E r);
        E Power(E l, E r);

        S Forms(S l, S r);

        S Goto(string var);
		S Loop(E e, S s);
    }
}
