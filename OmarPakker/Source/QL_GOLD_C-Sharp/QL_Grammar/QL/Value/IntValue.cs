using QL_Grammar.AST.Value;
using QL_Grammar.QL.Types;

namespace QL_Grammar.QL.Value
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
