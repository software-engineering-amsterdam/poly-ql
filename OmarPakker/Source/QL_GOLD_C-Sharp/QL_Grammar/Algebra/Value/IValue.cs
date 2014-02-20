using QL_Grammar.Algebra.Type;

namespace QL_Grammar.Algebra.Value
{
	public interface IValue
	{
		IType Type { get; }

		object Value { get; }
	}
}
