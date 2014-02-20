using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_Grammar.QLAlgebra.Type
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
