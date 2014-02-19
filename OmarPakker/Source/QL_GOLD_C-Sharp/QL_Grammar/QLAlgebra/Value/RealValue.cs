using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Types;

namespace QL_Grammar.QLAlgebra.Value
{
	public class RealValue : BaseValue<double>
	{
        public RealValue()
            : base(RealType.Instance)
        {

        }

		public RealValue(double value)
            : base(RealType.Instance, value)
		{

		}
	}
}
