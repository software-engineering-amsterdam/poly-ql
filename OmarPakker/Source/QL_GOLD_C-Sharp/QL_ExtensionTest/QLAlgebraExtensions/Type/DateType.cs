using QL_ExtensionTest.QLAlgebraExtensions.Value;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLAlgebraExtensions.Type
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
