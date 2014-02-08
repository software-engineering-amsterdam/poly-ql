using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
{
    public class UnknownType : IType
    {
        public static readonly UnknownType Instance = new UnknownType();

        public IValue DefaultValue { get { return new UnknownValue(); } }

        private UnknownType()
        {

        }

        public bool CompatibleWith(IType other)
        {
            return false;
        }

        public override string ToString()
        {
            return "unknown";
        }
    }
}
