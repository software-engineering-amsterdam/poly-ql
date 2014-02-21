using System;
using QL_ExtensionTest.QLAlgebraExtensions.Type;
using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLAlgebraExtensions.Value
{
	public class DateValue : BaseValue<DateTime>
	{
		public DateValue()
			: base(new DateType(), DateTime.MinValue)
		{

		}

		public DateValue(DateTime value)
			: base(new DateType(), value)
		{

		}
	}
}
