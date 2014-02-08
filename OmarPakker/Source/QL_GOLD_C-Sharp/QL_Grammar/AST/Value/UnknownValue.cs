using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
{
	public class UnknownValue : BaseValue<object>
	{
        public UnknownValue()
            : base(UnknownType.Instance)
        {

        }

        public UnknownValue(object value)
            : base(UnknownType.Instance, value)
		{

		}
	}
}
