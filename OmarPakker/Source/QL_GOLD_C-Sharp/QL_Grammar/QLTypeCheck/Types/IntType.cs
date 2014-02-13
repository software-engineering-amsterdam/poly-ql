using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Value;

namespace QL_Grammar.QLTypeCheck.Types
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
