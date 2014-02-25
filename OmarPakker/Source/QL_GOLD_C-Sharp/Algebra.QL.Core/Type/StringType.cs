using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Value;

namespace Algebra.QL.Core.Type
{
	public class StringType : BaseType
	{
		public override IValue DefaultValue { get { return new StringValue(); } }

		public StringType()
		{

		}

		public override string ToString()
		{
			return "string";
		}
	}
}
