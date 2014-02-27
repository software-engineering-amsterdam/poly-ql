using Algebra.Core.Factory;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Factory
{
	public abstract class QLFactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>
        : FactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>,
          IQLFactory<CombinedExpr<E1, E2>, CombinedStmnt<S1, S2>, CombinedType<T1, T2>>
        where E1 : IExprNode
        where E2 : IExprNode
        where S1 : IStmntNode
        where S2 : IStmntNode
        where T1 : ITypeNode
        where T2 : ITypeNode
		where F1 : IQLFactory<E1, S1, T1>
		where F2 : IQLFactory<E2, S2, T2>
	{
		public QLFactoryCombination(F1 f1, F2 f2)
			: base(f1, f2)
		{

		}

        public CombinedType<T1, T2> StringType()
        {
            return new CombinedType<T1, T2>(Factory1.StringType(), Factory2.StringType());
        }

        public CombinedType<T1, T2> IntType()
        {
            return new CombinedType<T1, T2>(Factory1.IntType(), Factory2.IntType());
        }

        public CombinedType<T1, T2> RealType()
        {
            return new CombinedType<T1, T2>(Factory1.RealType(), Factory2.RealType());
        }

        public CombinedType<T1, T2> BoolType()
        {
            return new CombinedType<T1, T2>(Factory1.BoolType(), Factory2.BoolType());
        }

		public CombinedExpr<E1, E2> String(string s)
		{
			return new CombinedExpr<E1, E2>(Factory1.String(s), Factory2.String(s));
		}

		public CombinedExpr<E1, E2> Int(int i)
		{
			return new CombinedExpr<E1, E2>(Factory1.Int(i), Factory2.Int(i));
		}

		public CombinedExpr<E1, E2> Real(double d)
		{
			return new CombinedExpr<E1, E2>(Factory1.Real(d), Factory2.Real(d));
		}

		public CombinedExpr<E1, E2> Bool(bool b)
		{
			return new CombinedExpr<E1, E2>(Factory1.Bool(b), Factory2.Bool(b));
		}

		public CombinedExpr<E1, E2> Variable(string var)
		{
			return new CombinedExpr<E1, E2>(Factory1.Variable(var), Factory2.Variable(var));
		}

		public CombinedExpr<E1, E2> Or(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Or(l.Item1, r.Item1), Factory2.Or(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> And(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.And(l.Item1, r.Item1), Factory2.And(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> Eq(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Eq(l.Item1, r.Item1), Factory2.Eq(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> NotEq(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.NotEq(l.Item1, r.Item1), Factory2.NotEq(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> LessThen(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.LessThen(l.Item1, r.Item1), Factory2.LessThen(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> GreaterThen(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.GreaterThen(l.Item1, r.Item1), Factory2.GreaterThen(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> LessOrEqualTo(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.LessOrEqualTo(l.Item1, r.Item1), Factory2.LessOrEqualTo(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> GreaterOrEqualTo(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.GreaterOrEqualTo(l.Item1, r.Item1), Factory2.GreaterOrEqualTo(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> Add(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Add(l.Item1, r.Item1), Factory2.Add(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> Subtract(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Subtract(l.Item1, r.Item1), Factory2.Subtract(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> Multiply(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Multiply(l.Item1, r.Item1), Factory2.Multiply(l.Item2, r.Item2));
		}

		public CombinedExpr<E1, E2> Divide(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
			return new CombinedExpr<E1, E2>(Factory1.Divide(l.Item1, r.Item1), Factory2.Divide(l.Item2, r.Item2));
		}

        public CombinedExpr<E1, E2> NegateBool(CombinedExpr<E1, E2> e)
        {
            return new CombinedExpr<E1, E2>(Factory1.NegateBool(e.Item1), Factory2.NegateBool(e.Item2));
        }

		public CombinedExpr<E1, E2> NegateNumeric(CombinedExpr<E1, E2> e)
		{
			return new CombinedExpr<E1, E2>(Factory1.NegateNumeric(e.Item1), Factory2.NegateNumeric(e.Item2));
		}

		public CombinedExpr<E1, E2> VarDecl(string var, CombinedType<T1, T2> t)
		{
			return new CombinedExpr<E1, E2>(Factory1.VarDecl(var, t.Item1), Factory2.VarDecl(var, t.Item2));
		}

		public CombinedExpr<E1, E2> VarAssign(string var, CombinedType<T1, T2> t, CombinedExpr<E1, E2> e)
		{
			return new CombinedExpr<E1, E2>(Factory1.VarAssign(var, t.Item1, e.Item1), Factory2.VarAssign(var, t.Item2, e.Item2));
		}

		public CombinedExpr<E1, E2> IfElse(CombinedExpr<E1, E2> toEval, CombinedExpr<E1, E2> ifTrue, CombinedExpr<E1, E2> ifFalse)
		{
			return new CombinedExpr<E1, E2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}

        public CombinedStmnt<S1, S2> Forms(CombinedStmnt<S1, S2> l, CombinedStmnt<S1, S2> r)
        {
            return new CombinedStmnt<S1, S2>(Factory1.Forms(l.Item1, r.Item1), Factory2.Forms(l.Item2, r.Item2));
        }

        public CombinedStmnt<S1, S2> Statements(CombinedStmnt<S1, S2> l, CombinedStmnt<S1, S2> r)
        {
            return new CombinedStmnt<S1, S2>(Factory1.Statements(l.Item1, r.Item1), Factory2.Statements(l.Item2, r.Item2));
        }

		public CombinedStmnt<S1, S2> Form(string var, CombinedStmnt<S1, S2> s)
		{
			return new CombinedStmnt<S1, S2>(Factory1.Form(var, s.Item1), Factory2.Form(var, s.Item2));
		}

		public CombinedStmnt<S1, S2> Goto(string var)
		{
			return new CombinedStmnt<S1, S2>(Factory1.Goto(var), Factory2.Goto(var));
		}

		public CombinedStmnt<S1, S2> Question(string s, CombinedExpr<E1, E2> e)
		{
			return new CombinedStmnt<S1, S2>(Factory1.Question(s, e.Item1), Factory2.Question(s, e.Item2));
		}

        public CombinedStmnt<S1, S2> Label(string s, CombinedExpr<E1, E2> e)
        {
            return new CombinedStmnt<S1, S2>(Factory1.Label(s, e.Item1), Factory2.Label(s, e.Item2));
        }

		public CombinedStmnt<S1, S2> If(CombinedExpr<E1, E2> toEval, CombinedStmnt<S1, S2> ifTrue)
		{
			return new CombinedStmnt<S1, S2>(Factory1.If(toEval.Item1, ifTrue.Item1), Factory2.If(toEval.Item2, ifTrue.Item2));
		}

		public CombinedStmnt<S1, S2> IfElse(CombinedExpr<E1, E2> toEval, CombinedStmnt<S1, S2> ifTrue, CombinedStmnt<S1, S2> ifFalse)
		{
			return new CombinedStmnt<S1, S2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
				Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
		}
    }
}
