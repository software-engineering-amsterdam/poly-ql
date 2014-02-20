using System;
using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
	//TODO: Abstract instead?
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

			for (System.Type myType = GetType(); myType != typeof(object); myType = myType.BaseType)
			{
				for (System.Type otherType = other.GetType(); otherType != typeof(object); otherType = otherType.BaseType)
				{
					if (myType.Equals(otherType))
					{
						return (IType)Activator.CreateInstance(myType);
					}
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
