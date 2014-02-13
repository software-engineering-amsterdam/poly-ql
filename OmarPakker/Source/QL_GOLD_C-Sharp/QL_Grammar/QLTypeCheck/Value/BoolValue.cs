using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_Grammar.QLTypeCheck.Value
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
