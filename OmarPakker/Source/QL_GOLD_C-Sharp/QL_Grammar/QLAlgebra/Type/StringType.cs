using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Type
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
