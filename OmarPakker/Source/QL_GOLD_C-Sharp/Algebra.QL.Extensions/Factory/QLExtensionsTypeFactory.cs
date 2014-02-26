using Algebra.Core.Type;
using Algebra.QL.Core.Factory;
using Algebra.QL.Extensions.Type;

namespace Algebra.QL.Extensions.Factory
{
    public class QLExtensionsTypeFactory : QLTypeFactory, IQLExtensionsTypeFactory
    {
        public IType DateType()
        {
            return new DateType();
        }
    }
}
