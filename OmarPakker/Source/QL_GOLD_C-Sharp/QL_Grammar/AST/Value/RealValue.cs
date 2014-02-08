using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
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
