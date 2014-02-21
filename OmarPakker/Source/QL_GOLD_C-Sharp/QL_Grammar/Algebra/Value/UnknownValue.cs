using QL_Grammar.Algebra.Type;

namespace QL_Grammar.Algebra.Value
{
    //TODO: Get rid of UnknownValue?
	public sealed class UnknownValue : IValue
	{
		private readonly IType type;
		public IType Type { get { return type; } }
		object IValue.Value { get { return null; } }

		public UnknownValue()
		{
			type = new UnknownType();
		}
	}
}
