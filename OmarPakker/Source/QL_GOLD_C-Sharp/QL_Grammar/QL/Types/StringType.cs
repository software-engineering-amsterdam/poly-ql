using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

namespace QL_Grammar.QL.Types
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
