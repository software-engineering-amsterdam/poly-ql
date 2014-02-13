using QL_Grammar.AST.Value;
using QL_Grammar.QL.Types;

namespace QL_Grammar.QL.Value
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
