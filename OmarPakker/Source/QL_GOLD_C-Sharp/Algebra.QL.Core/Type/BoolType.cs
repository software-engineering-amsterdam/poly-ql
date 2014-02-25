using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Value;

namespace Algebra.QL.Core.Type
{
	public class BoolType : BaseType
	{
		public override IValue DefaultValue { get { return new BoolValue(); } }

		public BoolType()
		{

		}

		public override string ToString()
		{
			return "bool";
		}
	}
}
