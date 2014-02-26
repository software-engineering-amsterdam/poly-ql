using Algebra.Core.Type;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Factory
{
    public class QLTypeFactory : IQLTypeFactory
    {
        public QLTypeFactory()
        {

        }

        public IType StringType()
        {
            return new StringType();
        }

        public IType IntType()
        {
            return new IntType();
        }

        public IType RealType()
        {
            return new RealType();
        }

        public IType BoolType()
        {
            return new BoolType();
        }
    }
}
