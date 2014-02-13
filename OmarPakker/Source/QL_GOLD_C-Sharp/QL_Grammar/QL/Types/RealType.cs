using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

namespace QL_Grammar.QL.Types
{
    public class RealType : NumericType
    {
        public new static readonly RealType Instance = new RealType();

        public override IValue DefaultValue { get { return new RealValue(); } }

        private RealType()
        {

        }

        public override string ToString()
        {
            return "real";
        }
    }
}
