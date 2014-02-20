using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Type
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
