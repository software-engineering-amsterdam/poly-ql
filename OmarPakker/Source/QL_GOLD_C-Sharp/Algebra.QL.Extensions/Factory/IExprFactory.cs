using System;

namespace Algebra.QL.Extensions.Factory
{
    public interface IExprFactory<E, T> : Core.Factory.IExprFactory<E, T>, ITypeFactory<T>
    {
        E Date(DateTime date);

        E Modulo(E l, E r);
        E Power(E l, E r);
        E Sum(string s);
        E Average(string s);
    }
}
