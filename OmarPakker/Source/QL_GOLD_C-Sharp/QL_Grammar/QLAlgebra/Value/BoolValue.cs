using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Types;

namespace QL_Grammar.QLAlgebra.Value
{
	public class BoolValue : BaseValue<bool>
	{
        public BoolValue()
            : base(BoolType.Instance)
        {

        }

		public BoolValue(bool value)
            : base(BoolType.Instance, value)
		{

		}
	}
}
