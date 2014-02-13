using System;
using QL_Grammar.Algebra.Factory;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;

namespace QL_Grammar.QLAlgebra.Factory
{
	public abstract class QLFactoryCombination<F1E, F1S, F2E, F2S, F1, F2>
		: FactoryCombination<F1E, F1S, F2E, F2S, F1, F2>, IQLStmntFactory<Tuple<F1E, F2E>, Tuple<F1S, F2S>>
		where F1 : IQLStmntFactory<F1E, F1S>
		where F2 : IQLStmntFactory<F2E, F2S>
	{
		public QLFactoryCombination(F1 f1, F2 f2)
			: base(f1, f2)
		{

		}

		public Tuple<F1E, F2E> String(string s)
		{
			return new Tuple<F1E, F2E>(Factory1.String(s), Factory2.String(s));
		}

		public Tuple<F1E, F2E> Int(int i)
		{
			return new Tuple<F1E, F2E>(Factory1.Int(i), Factory2.Int(i));
		}

		public Tuple<F1E, F2E> Real(double d)
		{
			return new Tuple<F1E, F2E>(Factory1.Real(d), Factory2.Real(d));
		}

		public Tuple<F1E, F2E> Bool(bool b)
		{
			return new Tuple<F1E, F2E>(Factory1.Bool(b), Factory2.Bool(b));
		}

		public Tuple<F1E, F2E> Literal(IValue value)
		{
			return new Tuple<F1E, F2E>(Factory1.Literal(value), Factory2.Literal(value));
		}

		public Tuple<F1E, F2E> Variable(string var)
		{
			return new Tuple<F1E, F2E>(Factory1.Variable(var), Factory2.Variable(var));
		}

		public Tuple<F1E, F2E> Or(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Or(l.Item1, r.Item1), Factory2.Or(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> And(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.And(l.Item1, r.Item1), Factory2.And(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Eq(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Eq(l.Item1, r.Item1), Factory2.Eq(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> NotEq(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.NotEq(l.Item1, r.Item1), Factory2.NotEq(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> LessThen(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.LessThen(l.Item1, r.Item1), Factory2.LessThen(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> GreaterThen(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.GreaterThen(l.Item1, r.Item1), Factory2.GreaterThen(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> LessOrEqualTo(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.LessOrEqualTo(l.Item1, r.Item1), Factory2.LessOrEqualTo(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> GreaterOrEqualTo(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.GreaterOrEqualTo(l.Item1, r.Item1), Factory2.GreaterOrEqualTo(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Add(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Add(l.Item1, r.Item1), Factory2.Add(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Subtract(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Subtract(l.Item1, r.Item1), Factory2.Subtract(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Multiply(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Multiply(l.Item1, r.Item1), Factory2.Multiply(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Divide(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
		{
			return new Tuple<F1E, F2E>(Factory1.Divide(l.Item1, r.Item1), Factory2.Divide(l.Item2, r.Item2));
		}

		public Tuple<F1E, F2E> Negate(Tuple<F1E, F2E> e)
		{
			return new Tuple<F1E, F2E>(Factory1.Negate(e.Item1), Factory2.Negate(e.Item2));
		}

		public Tuple<F1E, F2E> VarDecl(string var, IType t)
		{
			return new Tuple<F1E, F2E>(Factory1.VarDecl(var, t), Factory2.VarDecl(var, t));
		}

		public Tuple<F1E, F2E> VarAssign(string var, IType t, Tuple<F1E, F2E> e)
		{
			return new Tuple<F1E, F2E>(Factory1.VarAssign(var, t, e.Item1), Factory2.VarAssign(var, t, e.Item2));
		}

		public Tuple<F1E, F2E> IfElse(Tuple<F1E, F2E> toEval, Tuple<F1E, F2E> ifTrue, Tuple<F1E, F2E> ifFalse)
		{
			return new Tuple<F1E, F2E>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}

		public Tuple<F1S, F2S> Form(string var, Tuple<F1S, F2S> s)
		{
			return new Tuple<F1S, F2S>(Factory1.Form(var, s.Item1), Factory2.Form(var, s.Item2));
		}

		public Tuple<F1S, F2S> Goto(string var)
		{
			return new Tuple<F1S, F2S>(Factory1.Goto(var), Factory2.Goto(var));
		}

		public Tuple<F1S, F2S> Comp(Tuple<F1S, F2S> l, Tuple<F1S, F2S> r)
		{
			return new Tuple<F1S, F2S>(Factory1.Comp(l.Item1, r.Item1), Factory2.Comp(l.Item2, r.Item2));
		}

		public Tuple<F1S, F2S> Question(string s, bool b, Tuple<F1E, F2E> e)
		{
			return new Tuple<F1S, F2S>(Factory1.Question(s, b, e.Item1), Factory2.Question(s, b, e.Item2));
		}

		public Tuple<F1S, F2S> If(Tuple<F1E, F2E> toEval, Tuple<F1S, F2S> ifTrue)
		{
			return new Tuple<F1S, F2S>(Factory1.If(toEval.Item1, ifTrue.Item1), Factory2.If(toEval.Item2, ifTrue.Item2));
		}

		public Tuple<F1S, F2S> IfElse(Tuple<F1E, F2E> toEval, Tuple<F1S, F2S> ifTrue, Tuple<F1S, F2S> ifFalse)
		{
			return new Tuple<F1S, F2S>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}
	}
}
