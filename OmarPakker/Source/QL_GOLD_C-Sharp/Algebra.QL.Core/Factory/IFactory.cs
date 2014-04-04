
namespace Algebra.QL.Core.Factory
{
    public interface IFactory<S, E, T> : IStmntFactory<S, E, T>, IExprFactory<E, T>, ITypeFactory<T>, Algebra.Core.Factory.IFactory<S, E, T>
    {

    }
}
