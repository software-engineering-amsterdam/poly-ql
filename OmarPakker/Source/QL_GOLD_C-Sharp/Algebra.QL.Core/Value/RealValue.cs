using Algebra.Core.Value;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Value
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
