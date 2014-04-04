
namespace Algebra.Core.Factory
{
    public interface IFactory<S, E, T> : IStmntFactory<S, E, T>, IExprFactory<E, T>, ITypeFactory<T>
    {

    }
}
