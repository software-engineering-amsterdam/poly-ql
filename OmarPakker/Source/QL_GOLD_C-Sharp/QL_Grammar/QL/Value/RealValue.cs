using QL_Grammar.AST.Value;
using QL_Grammar.QL.Types;

namespace QL_Grammar.QL.Value
{
	public class RealValue : BaseValue<double>
	{
        public RealValue()
            : base(RealType.Instance)
        {

        }

		public RealValue(double value)
            : base(RealType.Instance, value)
		{

		}
	}
}
