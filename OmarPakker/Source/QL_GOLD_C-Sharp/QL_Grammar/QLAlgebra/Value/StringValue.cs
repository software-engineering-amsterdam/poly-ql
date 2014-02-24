using System;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Type;

namespace QL_Grammar.QLAlgebra.Value
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
	}
}
