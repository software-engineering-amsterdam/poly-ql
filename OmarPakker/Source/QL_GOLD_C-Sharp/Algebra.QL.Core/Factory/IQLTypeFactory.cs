using Algebra.Core.Factory;
using Algebra.Core.Type;

namespace Algebra.QL.Core.Factory
{
    public interface IQLTypeFactory : ITypeFactory
    {
        IType StringType();
        IType IntType();
        IType RealType();
        IType BoolType();
    }
}
