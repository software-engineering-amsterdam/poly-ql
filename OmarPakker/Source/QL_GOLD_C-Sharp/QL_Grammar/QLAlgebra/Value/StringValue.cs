using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Types;

namespace QL_Grammar.QLAlgebra.Value
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
