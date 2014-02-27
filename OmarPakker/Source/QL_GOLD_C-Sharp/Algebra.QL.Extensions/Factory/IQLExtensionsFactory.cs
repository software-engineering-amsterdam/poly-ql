using System;
using Algebra.Core.Tree;
using Algebra.QL.Core.Factory;

namespace Algebra.QL.Extensions.Factory
{
    public interface IQLExtensionsFactory<E, S, T> : IQLFactory<E, S, T>
        where E : IExprNode
        where S : IStmntNode
        where T : ITypeNode
    {
        T DateType();

		E Date(DateTime date);

        E Modulo(E l, E r);
        E Power(E l, E r);

		S Loop(E e, S s);
    }
}
