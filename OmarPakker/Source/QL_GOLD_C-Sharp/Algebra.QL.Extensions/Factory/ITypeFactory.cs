
namespace Algebra.QL.Extensions.Factory
{
    public interface ITypeFactory<T> : Core.Factory.ITypeFactory<T>
    {
        T DateType();
    }
}
