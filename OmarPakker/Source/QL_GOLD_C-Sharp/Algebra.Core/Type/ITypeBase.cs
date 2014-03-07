
namespace Algebra.Core.Type
{
    public interface ITypeBase<T>
        where T : ITypeBase<T>
    {
        T SuperType { get; }

        bool IsChildOf(T other);
        T GetLeastUpperBound(T other);
    }
}
