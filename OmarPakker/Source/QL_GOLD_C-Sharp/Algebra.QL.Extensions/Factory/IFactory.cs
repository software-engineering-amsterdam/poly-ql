
namespace Algebra.QL.Extensions.Factory
{
    public interface IFactory<S, E, T> : IStmntFactory<S, E, T>, IExprFactory<E, T>, ITypeFactory<T>, QL.Core.Factory.IFactory<S, E, T>
    {

    }
}
