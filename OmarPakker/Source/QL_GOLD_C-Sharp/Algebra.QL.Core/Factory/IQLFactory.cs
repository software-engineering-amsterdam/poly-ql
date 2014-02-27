using Algebra.Core.Factory;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Factory
{
	public interface IQLFactory<E, S, T> : IFactory<E, S, T>
        where E : IExprNode
        where S : IStmntNode
        where T : ITypeNode
	{
        T StringType();
        T IntType();
        T RealType();
        T BoolType();

		E String(string s);
		E Int(int i);
		E Real(double d);
		E Bool(bool b);
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

        E NegateBool(E e);
		E NegateNumeric(E e);

		E VarDecl(string var, T t);
		E VarAssign(string var, T t, E e);

		E IfElse(E toEval, E ifTrue, E ifFalse);

		S Form(string var, S s);
		S Goto(string var);

		S Comp(S l, S r);
		S Question(string s, E e);
        S Label(string s, E e);
		S If(E toEval, S ifTrue);
		S IfElse(E toEval, S ifTrue, S ifFalse);
	}
}
