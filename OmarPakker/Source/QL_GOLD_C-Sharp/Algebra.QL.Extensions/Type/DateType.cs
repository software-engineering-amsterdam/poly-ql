using Algebra.QL.Extensions.Value;
using Algebra.Core.Type;
using Algebra.Core.Value;

namespace Algebra.QL.Extensions.Type
{
	public class DateType : BaseType
	{
		public override IValue DefaultValue { get { return new DateValue(); } }

		public DateType()
		{

		}

		public override string ToString()
		{
			return "date";
		}
	}
}
