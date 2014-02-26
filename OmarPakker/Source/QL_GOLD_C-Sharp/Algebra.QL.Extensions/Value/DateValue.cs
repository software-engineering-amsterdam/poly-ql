using System;
using Algebra.QL.Extensions.Type;
using Algebra.Core.Value;

namespace Algebra.QL.Extensions.Value
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
