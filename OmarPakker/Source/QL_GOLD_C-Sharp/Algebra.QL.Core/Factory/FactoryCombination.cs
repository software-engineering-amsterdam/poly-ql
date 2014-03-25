using Algebra.Core.Helpers;

namespace Algebra.QL.Core.Factory
{
    public abstract class FactoryCombination<S1, E1, T1, S2, E2, T2, F1, F2>
        : Algebra.Core.Factory.FactoryCombination<S1, E1, T1, S2, E2, T2, F1, F2>,
          IStmntFactory<IPair<S1, S2>, IPair<E1, E2>, IPair<T1, T2>>
        where F1 : IStmntFactory<S1, E1, T1>
        where F2 : IStmntFactory<S2, E2, T2>
    {
        public FactoryCombination(F1 f1, F2 f2)
            : base(f1, f2)
        {

        }

        public IPair<T1, T2> StringType()
        {
            return new Pair<T1, T2>(Factory1.StringType(), Factory2.StringType());
        }

        public IPair<T1, T2> IntType()
        {
            return new Pair<T1, T2>(Factory1.IntType(), Factory2.IntType());
        }

        public IPair<T1, T2> RealType()
        {
            return new Pair<T1, T2>(Factory1.RealType(), Factory2.RealType());
        }

        public IPair<T1, T2> BoolType()
        {
            return new Pair<T1, T2>(Factory1.BoolType(), Factory2.BoolType());
        }

        public IPair<E1, E2> String(string s)
        {
            return new Pair<E1, E2>(Factory1.String(s), Factory2.String(s));
        }

        public IPair<E1, E2> Int(int i)
        {
            return new Pair<E1, E2>(Factory1.Int(i), Factory2.Int(i));
        }

        public IPair<E1, E2> Real(double d)
        {
            return new Pair<E1, E2>(Factory1.Real(d), Factory2.Real(d));
        }

        public IPair<E1, E2> Bool(bool b)
        {
            return new Pair<E1, E2>(Factory1.Bool(b), Factory2.Bool(b));
        }

        public IPair<E1, E2> Variable(string var)
        {
            return new Pair<E1, E2>(Factory1.Variable(var), Factory2.Variable(var));
        }

        public IPair<E1, E2> Or(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Or(l.Item1, r.Item1), Factory2.Or(l.Item2, r.Item2));
        }

        public IPair<E1, E2> And(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.And(l.Item1, r.Item1), Factory2.And(l.Item2, r.Item2));
        }

        public IPair<E1, E2> Eq(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Eq(l.Item1, r.Item1), Factory2.Eq(l.Item2, r.Item2));
        }

        public IPair<E1, E2> NotEq(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.NotEq(l.Item1, r.Item1), Factory2.NotEq(l.Item2, r.Item2));
        }

        public IPair<E1, E2> LessThen(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.LessThen(l.Item1, r.Item1), Factory2.LessThen(l.Item2, r.Item2));
        }

        public IPair<E1, E2> GreaterThen(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.GreaterThen(l.Item1, r.Item1), Factory2.GreaterThen(l.Item2, r.Item2));
        }

        public IPair<E1, E2> LessOrEqualTo(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.LessOrEqualTo(l.Item1, r.Item1), Factory2.LessOrEqualTo(l.Item2, r.Item2));
        }

        public IPair<E1, E2> GreaterOrEqualTo(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.GreaterOrEqualTo(l.Item1, r.Item1), Factory2.GreaterOrEqualTo(l.Item2, r.Item2));
        }

        public IPair<E1, E2> Add(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Add(l.Item1, r.Item1), Factory2.Add(l.Item2, r.Item2));
        }

        public IPair<E1, E2> Subtract(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Subtract(l.Item1, r.Item1), Factory2.Subtract(l.Item2, r.Item2));
        }

        public IPair<E1, E2> Multiply(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Multiply(l.Item1, r.Item1), Factory2.Multiply(l.Item2, r.Item2));
        }

        public IPair<E1, E2> Divide(IPair<E1, E2> l, IPair<E1, E2> r)
        {
            return new Pair<E1, E2>(Factory1.Divide(l.Item1, r.Item1), Factory2.Divide(l.Item2, r.Item2));
        }

        public IPair<E1, E2> NegateBool(IPair<E1, E2> e)
        {
            return new Pair<E1, E2>(Factory1.NegateBool(e.Item1), Factory2.NegateBool(e.Item2));
        }

        public IPair<E1, E2> NegateNumeric(IPair<E1, E2> e)
        {
            return new Pair<E1, E2>(Factory1.NegateNumeric(e.Item1), Factory2.NegateNumeric(e.Item2));
        }

        public IPair<E1, E2> VarDecl(string var, IPair<T1, T2> t)
        {
            return new Pair<E1, E2>(Factory1.VarDecl(var, t.Item1), Factory2.VarDecl(var, t.Item2));
        }

        public IPair<E1, E2> VarAssign(string var, IPair<T1, T2> t, IPair<E1, E2> e)
        {
            return new Pair<E1, E2>(Factory1.VarAssign(var, t.Item1, e.Item1), Factory2.VarAssign(var, t.Item2, e.Item2));
        }

        public IPair<E1, E2> IfElse(IPair<E1, E2> toEval, IPair<E1, E2> ifTrue, IPair<E1, E2> ifFalse)
        {
            return new Pair<E1, E2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
                Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
        }

        public IPair<S1, S2> Statements(IPair<S1, S2> l, IPair<S1, S2> r)
        {
            return new Pair<S1, S2>(Factory1.Statements(l.Item1, r.Item1), Factory2.Statements(l.Item2, r.Item2));
        }

        public IPair<S1, S2> Form(string var, IPair<S1, S2> s)
        {
            return new Pair<S1, S2>(Factory1.Form(var, s.Item1), Factory2.Form(var, s.Item2));
        }

        public IPair<S1, S2> Question(string s, IPair<E1, E2> e)
        {
            return new Pair<S1, S2>(Factory1.Question(s, e.Item1), Factory2.Question(s, e.Item2));
        }

        public IPair<S1, S2> Label(string s, IPair<E1, E2> e)
        {
            return new Pair<S1, S2>(Factory1.Label(s, e.Item1), Factory2.Label(s, e.Item2));
        }

        public IPair<S1, S2> If(IPair<E1, E2> toEval, IPair<S1, S2> ifTrue)
        {
            return new Pair<S1, S2>(Factory1.If(toEval.Item1, ifTrue.Item1), Factory2.If(toEval.Item2, ifTrue.Item2));
        }

        public IPair<S1, S2> IfElse(IPair<E1, E2> toEval, IPair<S1, S2> ifTrue, IPair<S1, S2> ifFalse)
        {
            return new Pair<S1, S2>(Factory1.IfElse(toEval.Item1, ifTrue.Item1, ifFalse.Item1),
                Factory2.IfElse(toEval.Item2, ifTrue.Item2, ifFalse.Item2));
        }
    }
}
