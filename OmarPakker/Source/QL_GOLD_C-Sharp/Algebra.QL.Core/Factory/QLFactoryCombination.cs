using System;
using Algebra.Core.Factory;
using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Core.Factory
{
	public abstract class QLFactoryCombination<E1, S1, E2, S2, F1, F2>
		: FactoryCombination<E1, S1, E2, S2, F1, F2>, IQLFactory<Tuple<E1, E2>, Tuple<S1, S2>>
		where F1 : IQLFactory<E1, S1>
		where F2 : IQLFactory<E2, S2>
	{
		public QLFactoryCombination(F1 f1, F2 f2)
			: base(f1, f2)
		{

		}

		public IType StringType()
		{
			return new StringType();
		}

		public IType IntType()
		{
			return new IntType();
		}

		public IType RealType()
		{
			return new RealType();
		}

		public IType BoolType()
		{
			return new BoolType();
		}

		public Tuple<E1, E2> String(string s)
		{
			return new Tuple<E1, E2>(Factory1.String(s), Factory2.String(s));
		}

		public Tuple<E1, E2> Int(int i)
		{
			return new Tuple<E1, E2>(Factory1.Int(i), Factory2.Int(i));
		}

		public Tuple<E1, E2> Real(double d)
		{
			return new Tuple<E1, E2>(Factory1.Real(d), Factory2.Real(d));
		}

		public Tuple<E1, E2> Bool(bool b)
		{
			return new Tuple<E1, E2>(Factory1.Bool(b), Factory2.Bool(b));
		}

		public Tuple<E1, E2> Literal(IValue value)
		{
			return new Tuple<E1, E2>(Factory1.Literal(value), Factory2.Literal(value));
		}

		public Tuple<E1, E2> Variable(string var)
		{
			return new Tuple<E1, E2>(Factory1.Variable(var), Factory2.Variable(var));
		}

		public Tuple<E1, E2> Or(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Or(l.Item1, r.Item1), Factory2.Or(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> And(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.And(l.Item1, r.Item1), Factory2.And(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Eq(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Eq(l.Item1, r.Item1), Factory2.Eq(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> NotEq(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.NotEq(l.Item1, r.Item1), Factory2.NotEq(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> LessThen(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.LessThen(l.Item1, r.Item1), Factory2.LessThen(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> GreaterThen(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.GreaterThen(l.Item1, r.Item1), Factory2.GreaterThen(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> LessOrEqualTo(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.LessOrEqualTo(l.Item1, r.Item1), Factory2.LessOrEqualTo(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> GreaterOrEqualTo(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.GreaterOrEqualTo(l.Item1, r.Item1), Factory2.GreaterOrEqualTo(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Add(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Add(l.Item1, r.Item1), Factory2.Add(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Subtract(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Subtract(l.Item1, r.Item1), Factory2.Subtract(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Multiply(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Multiply(l.Item1, r.Item1), Factory2.Multiply(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Divide(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
			return new Tuple<E1, E2>(Factory1.Divide(l.Item1, r.Item1), Factory2.Divide(l.Item2, r.Item2));
		}

		public Tuple<E1, E2> Negate(IType t, Tuple<E1, E2> e)
		{
			return new Tuple<E1, E2>(Factory1.Negate(t, e.Item1), Factory2.Negate(t, e.Item2));
		}

		public Tuple<E1, E2> VarDecl(string var, IType t)
		{
			return new Tuple<E1, E2>(Factory1.VarDecl(var, t), Factory2.VarDecl(var, t));
		}

		public Tuple<E1, E2> VarAssign(string var, IType t, Tuple<E1, E2> e)
		{
			return new Tuple<E1, E2>(Factory1.VarAssign(var, t, e.Item1), Factory2.VarAssign(var, t, e.Item2));
		}

		public Tuple<E1, E2> IfElse(Tuple<E1, E2> toEval, Tuple<E1, E2> ifTrue, Tuple<E1, E2> ifFalse)
		{
			return new Tuple<E1, E2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}

		public Tuple<S1, S2> Form(string var, Tuple<S1, S2> s)
		{
			return new Tuple<S1, S2>(Factory1.Form(var, s.Item1), Factory2.Form(var, s.Item2));
		}

		public Tuple<S1, S2> Goto(string var)
		{
			return new Tuple<S1, S2>(Factory1.Goto(var), Factory2.Goto(var));
		}

		public Tuple<S1, S2> Comp(Tuple<S1, S2> l, Tuple<S1, S2> r)
		{
			return new Tuple<S1, S2>(Factory1.Comp(l.Item1, r.Item1), Factory2.Comp(l.Item2, r.Item2));
		}

		public Tuple<S1, S2> Question(string s, bool b, Tuple<E1, E2> e)
		{
			return new Tuple<S1, S2>(Factory1.Question(s, b, e.Item1), Factory2.Question(s, b, e.Item2));
		}

		public Tuple<S1, S2> If(Tuple<E1, E2> toEval, Tuple<S1, S2> ifTrue)
		{
			return new Tuple<S1, S2>(Factory1.If(toEval.Item1, ifTrue.Item1), Factory2.If(toEval.Item2, ifTrue.Item2));
		}

		public Tuple<S1, S2> IfElse(Tuple<E1, E2> toEval, Tuple<S1, S2> ifTrue, Tuple<S1, S2> ifFalse)
		{
			return new Tuple<S1, S2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}
	}
}
