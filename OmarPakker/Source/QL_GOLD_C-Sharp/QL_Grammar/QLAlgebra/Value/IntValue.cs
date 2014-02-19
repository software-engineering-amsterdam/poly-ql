using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Types;

namespace QL_Grammar.QLAlgebra.Value
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
