using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Value
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
	}
}
