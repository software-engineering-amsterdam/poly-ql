using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_Grammar.QLTypeCheck.Value
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
