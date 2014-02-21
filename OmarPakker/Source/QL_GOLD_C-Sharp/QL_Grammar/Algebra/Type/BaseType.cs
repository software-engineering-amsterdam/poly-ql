using System;
using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
	//TODO: Abstract instead?
    //TODO: Move away from reflection? If so, use some other way to handle type inheritance as actual inheritance info needs reflection.
	public class BaseType : IType
	{
		public virtual IValue DefaultValue { get { return new UnknownValue(); } }

		public BaseType()
		{

		}

		public IType GetLeastUpperBound(IType other)
		{
			if (Equals(other) || other.GetType().IsSubclassOf(GetType()))
			{
				return this;
			}
			else if (GetType().IsSubclassOf(other.GetType()))
			{
				return other;
			}

			for (System.Type baseType = GetType().BaseType; baseType != typeof(object); baseType = baseType.BaseType)
			{
                if (other.GetType().IsSubclassOf(baseType))
                {
                    return (IType)Activator.CreateInstance(baseType);
                }
			}

			throw new InvalidOperationException("No least upper bound in existence...");
		}

		public bool CompatibleWith(IType other)
		{
			return Equals(other)
				|| other.GetType().IsSubclassOf(GetType())
				|| GetType().IsSubclassOf(other.GetType());
		}

		public sealed override bool Equals(object obj)
		{
			return GetType().Equals(obj.GetType());
		}

		public sealed override int GetHashCode()
		{
			return GetType().GetHashCode();
		}

		public override string ToString()
		{
			return "undefined";
		}
	}
}
