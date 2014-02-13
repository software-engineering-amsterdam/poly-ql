using QL_Grammar.AST.Value;
using QL_Grammar.QL.Types;

namespace QL_Grammar.QL.Value
{
	public class StringValue : BaseValue<string>
	{
        public StringValue()
            : base(StringType.Instance)
        {

        }

		public StringValue(string value)
			: base(StringType.Instance, value)
		{

		}
	}
}
