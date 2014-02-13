using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

namespace QL_Grammar.QL.Types
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
