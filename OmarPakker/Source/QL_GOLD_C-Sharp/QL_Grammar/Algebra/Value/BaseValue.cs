using QL_Grammar.Algebra.Type;

namespace QL_Grammar.Algebra.Value
{
	public abstract class BaseValue<T> : IValue
	{
        public T Value { get; private set; }
        object IValue.Value { get { return Value; } }
        public IType Type { get; private set; }

        public BaseValue(IType type)
            : this(type, default(T))
        {

        }

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
	}
}
