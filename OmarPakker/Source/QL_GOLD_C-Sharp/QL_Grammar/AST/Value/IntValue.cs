using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
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
