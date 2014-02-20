using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
	public interface IType
	{
		IValue DefaultValue { get; }

		IType GetLeastUpperBound(IType other);
		bool CompatibleWith(IType other);
	}
}
