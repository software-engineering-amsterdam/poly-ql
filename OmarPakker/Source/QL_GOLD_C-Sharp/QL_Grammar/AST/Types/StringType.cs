using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
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
