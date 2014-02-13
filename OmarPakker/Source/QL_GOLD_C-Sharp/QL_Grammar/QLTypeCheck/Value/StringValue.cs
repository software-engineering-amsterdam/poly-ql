using QL_Grammar.Algebra.Value;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_Grammar.QLTypeCheck.Value
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
