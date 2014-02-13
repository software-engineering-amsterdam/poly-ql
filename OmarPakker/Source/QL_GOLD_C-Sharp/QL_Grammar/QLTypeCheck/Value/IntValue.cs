using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_Grammar.QLTypeCheck.Value
{
    public class IntValue : BaseValue<int>
	{
        public IntValue()
            : base(IntType.Instance)
        {

        }

		public IntValue(int value)
            : base(IntType.Instance, value)
		{

		}
	}
}
