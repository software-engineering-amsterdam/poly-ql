using System;
using Algebra.Core.Value;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Value
{
	public class StringValue : BaseValue<string>
	{
        public StringValue()
			: base(new StringType(), String.Empty)
        {

        }

		public StringValue(string value)
			: base(new StringType(), value)
		{

		}

        public override string ToString()
        {
            return "\"" + base.ToString() + "\"";
        }
	}
}
