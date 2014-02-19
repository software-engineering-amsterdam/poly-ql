using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Types
{
    public class BoolType : IType
    {
        public static readonly BoolType Instance = new BoolType();

        public IValue DefaultValue { get { return new BoolValue(); } }

        private BoolType()
        {

        }

        public bool CompatibleWith(IType other)
        {
            return Equals(other);
        }

        public override string ToString()
        {
            return "bool";
        }
    }
}
