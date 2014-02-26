using Algebra.Core.Type;
using Algebra.QL.Core.Factory;

namespace Algebra.QL.Extensions.Factory
{
    public interface IQLExtensionsTypeFactory : IQLTypeFactory
    {
        IType DateType();
    }
}
