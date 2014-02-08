using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
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
