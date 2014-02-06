
namespace QL_Grammar.Value
{
	public abstract class BaseValue<T> : IValue
	{
		public T Value { get; private set; }

		public BaseValue(T value)
		{
			Value = value;
		}
	}
}
