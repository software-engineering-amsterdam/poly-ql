using Algebra.Core.Type;

namespace Algebra.Core.Value
{
	public abstract class BaseValue<T> : IValue
	{
		public IType Type { get; private set; }
		object IValue.Value { get { return Value; } }
        public T Value { get; private set; }

		public BaseValue(IType type, T value)
		{
			Type = type;
			Value = value;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is BaseValue<T>))
			{
				return false;
			}

			return ((BaseValue<T>)obj).Value.Equals(Value);
		}

		public override int GetHashCode()
		{
			return Value.GetHashCode();
		}

        public override string ToString()
        {
            return Value.ToString();
        }
	}
}
