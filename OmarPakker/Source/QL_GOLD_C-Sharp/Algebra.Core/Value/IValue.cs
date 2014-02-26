using Algebra.Core.Type;

namespace Algebra.Core.Value
{
	public interface IValue
	{
		IType Type { get; }

		object Value { get; }
	}
}
