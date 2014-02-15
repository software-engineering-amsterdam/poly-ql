using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Types
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
