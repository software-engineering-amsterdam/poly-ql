using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Value;

namespace QL_Grammar.QLTypeCheck.Types
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
