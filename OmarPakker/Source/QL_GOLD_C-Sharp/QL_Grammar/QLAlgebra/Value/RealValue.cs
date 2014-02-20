using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Type;

namespace QL_Grammar.QLAlgebra.Value
{
	public class RealValue : BaseValue<double>
	{
        public RealValue()
			: base(new RealType(), 0)
        {

        }

		public RealValue(double value)
            : base(new RealType(), value)
		{

		}
	}
}
