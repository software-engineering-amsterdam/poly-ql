using Algebra.Core.Value;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Value
{
	public class BoolValue : BaseValue<bool>
	{
        public BoolValue()
			: base(new BoolType(), false)
        {

        }

		public BoolValue(bool value)
			: base(new BoolType(), value)
		{

		}
	}
}
