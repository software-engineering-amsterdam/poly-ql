using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Value;

namespace Algebra.QL.Core.Type
{
	public class RealType : BaseType
	{
		public override IValue DefaultValue { get { return new RealValue(); } }

		public RealType()
		{

		}

		public override string ToString()
		{
			return "real";
		}
	}
}
