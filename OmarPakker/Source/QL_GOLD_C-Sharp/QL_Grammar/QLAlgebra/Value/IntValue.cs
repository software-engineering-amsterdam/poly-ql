using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Type;

namespace QL_Grammar.QLAlgebra.Value
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
