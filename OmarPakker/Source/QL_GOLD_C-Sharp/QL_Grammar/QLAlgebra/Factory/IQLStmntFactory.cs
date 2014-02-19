using QL_Grammar.Algebra.Factory;

namespace QL_Grammar.QLAlgebra.Factory
{
	public interface IQLStmntFactory<E, S> : IQLExprFactory<E>, IStmntFactory<E, S>
	{
		S Form(string var, S s);
		S Goto(string var);

		S Comp(S l, S r);
		S Question(string s, bool b, E e);
		S If(E toEval, S ifTrue);
		S IfElse(E toEval, S ifTrue, S ifFalse);
	}
}
