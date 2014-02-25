using Algebra.Core.Value;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Value
{
    public class IntValue : BaseValue<int>
	{
        public IntValue()
			: base(new IntType(), 0)
        {

        }

		public IntValue(int value)
            : base(new IntType(), value)
		{

		}
	}
}
