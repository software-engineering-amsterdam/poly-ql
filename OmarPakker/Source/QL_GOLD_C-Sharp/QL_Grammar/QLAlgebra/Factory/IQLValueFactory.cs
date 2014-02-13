using QL_Grammar.Algebra.Factory;

namespace QL_Grammar.QLAlgebra.Factory
{
	public interface IQLValueFactory<E> : IValueFactory<E>
	{
		E String(string s);
		E Int(int i);
		E Real(double d);
		E Bool(bool b);
	}
}
