using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
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
