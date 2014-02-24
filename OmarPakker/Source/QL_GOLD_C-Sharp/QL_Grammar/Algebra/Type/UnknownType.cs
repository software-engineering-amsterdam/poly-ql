using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
	//TODO: Get rid of UnknownType?
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
