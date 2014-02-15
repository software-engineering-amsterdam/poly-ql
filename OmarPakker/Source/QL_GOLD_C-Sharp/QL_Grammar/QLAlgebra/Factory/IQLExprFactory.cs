using QL_Grammar.Algebra.Factory;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;

namespace QL_Grammar.QLAlgebra.Factory
{
	public interface IQLExprFactory<E> : IQLValueFactory<E>, IExprFactory<E>
	{
		E Literal(IValue value);
		E Variable(string var);

		E Or(E l, E r);
		E And(E l, E r);
		E Eq(E l, E r);
		E NotEq(E l, E r);
		E LessThen(E l, E r);
		E GreaterThen(E l, E r);
		E LessOrEqualTo(E l, E r);
		E GreaterOrEqualTo(E l, E r);

		E Add(E l, E r);
		E Subtract(E l, E r);
		E Multiply(E l, E r);
		E Divide(E l, E r);

		E Negate(E e);

		E VarDecl(string var, IType t);
		E VarAssign(string var, IType t, E e);

		E IfElse(E toEval, E ifTrue, E ifFalse);
	}
}
