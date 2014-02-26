using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Value;

namespace Algebra.QL.Core.Type
{
	public class IntType : RealType
	{
		public override IValue DefaultValue { get { return new IntValue(); } }

		public IntType()
		{

		}

		public override string ToString()
		{
			return "int";
		}
	}
}
