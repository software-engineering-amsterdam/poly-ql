using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Types
{
    public class StringType : IType
    {
        public static readonly StringType Instance = new StringType();

        public IValue DefaultValue { get { return new StringValue(); } }

        private StringType()
        {

        }

        public bool CompatibleWith(IType other)
        {
            return Equals(other);
        }

        public override string ToString()
        {
            return "string";
        }
    }
}
