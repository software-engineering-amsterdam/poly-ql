using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Type;

namespace QL_Grammar.QLAlgebra.Value
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
