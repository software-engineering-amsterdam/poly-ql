using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
{
    public class IntType : NumericType
    {
        public new static readonly IntType Instance = new IntType();

        public override IValue DefaultValue { get { return new IntValue(); } }

        private IntType()
        {

        }

        public override string ToString()
        {
            return "int";
        }
    }
}
