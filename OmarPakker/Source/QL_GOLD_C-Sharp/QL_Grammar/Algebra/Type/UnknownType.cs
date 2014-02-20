using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
	//TODO: Can we get rid of UnknownType & UnknownValue?
	public sealed class UnknownType : IType
	{
		public IValue DefaultValue { get { return null; } }

		public IType GetLeastUpperBound(IType other)
		{
			return this;
		}

		public bool CompatibleWith(IType other)
		{
			return false;
		}

		public override string ToString()
		{
			return "unknown";
		}
	}
}
