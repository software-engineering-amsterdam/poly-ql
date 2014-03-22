
namespace Algebra.QL.Core.Factory
{
    public interface ITypeFactory<T> : Algebra.Core.Factory.ITypeFactory<T>
    {
        T StringType();
        T IntType();
        T RealType();
        T BoolType();
    }
}
