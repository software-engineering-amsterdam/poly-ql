
namespace Algebra.QL.Extensions.Factory
{
    public interface IStmntFactory<S, E, T> : Core.Factory.IStmntFactory<S, E, T>, IExprFactory<E, T>
    {
        S Forms(S l, S r);

        S Goto();
        S Repeat(E e, S s);
    }
}
