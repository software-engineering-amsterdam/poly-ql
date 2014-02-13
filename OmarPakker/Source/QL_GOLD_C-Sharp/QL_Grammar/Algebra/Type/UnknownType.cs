using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
    public class UnknownType : IType
    {
        public static readonly UnknownType Instance = new UnknownType();

        public IValue DefaultValue { get { return null; } }

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
