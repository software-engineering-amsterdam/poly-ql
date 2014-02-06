
namespace QL_Grammar.Factory
{
	public interface IFactory<E, S>
	{
		E String(string s);
		E Int(int i);
		E Real(double d);
		E Bool(bool b);

		E IfElse(E toEval, E ifTrue, E ifFalse);
		E Or(E a, E b);
		E And(E a, E b);
		E Eq(E a, E b);
		E NotEq(E a, E b);
		E LessThen(E a, E b);
		E GreaterThen(E a, E b);
		E LessOrEqualTo(E a, E b);
		E GreaterOrEqualTo(E a, E b);

		E Add(E a, E b);
		E Subtract(E a, E b);
		E Multiply(E a, E b);
		E Divide(E a, E b);

		E Negate(E a);

		E Variable(string var);
		E Assign(string var, E a);

		//S ExprToStmnt(E expr);
		//S Composition(S a, S b);
	}
}
