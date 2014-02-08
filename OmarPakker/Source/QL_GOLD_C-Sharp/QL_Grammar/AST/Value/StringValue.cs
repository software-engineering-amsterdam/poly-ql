using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
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
