using Algebra.Core.Value;

namespace Algebra.Core.Type
{
    //TODO: this interface probably doesn't really have any use as all types extend from BaseType anyway
	public interface IType
	{
		IValue DefaultValue { get; }

		IType GetLeastUpperBound(IType other);
		bool CompatibleWith(IType other);
	}
}
