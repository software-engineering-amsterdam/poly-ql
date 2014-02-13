using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
{
	public interface IValue
	{
		object Value { get; }
        IType Type { get; }
	}
}
