using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Type
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
