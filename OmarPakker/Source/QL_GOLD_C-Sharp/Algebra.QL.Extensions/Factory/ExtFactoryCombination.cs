using System;
using Algebra.Core.Helpers;

namespace Algebra.QL.Extensions.Factory
{
    public class ExtFactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>
		: Algebra.QL.Core.Factory.FactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>,
          IExtFactory<IPair<E1, E2>, IPair<S1, S2>, IPair<T1, T2>>
		where F1 : IExtFactory<E1, S1, T1>
		where F2 : IExtFactory<E2, S2, T2>
    {
        public ExtFactoryCombination(F1 f1, F2 f2)
            : base(f1, f2)
        {

        }

        public IPair<T1, T2> DateType()
        {
            return new Pair<T1, T2>(Factory1.DateType(), Factory2.DateType());
        }

        public IPair<E1, E2> Date(DateTime date)
		{
            return new Pair<E1, E2>(Factory1.Date(date), Factory2.Date(date));
		}

        public IPair<E1, E2> Modulo(IPair<E1, E2> l, IPair<E1, E2> r)
		{
            return new Pair<E1, E2>(Factory1.Modulo(l.Item1, r.Item1), Factory2.Modulo(l.Item2, r.Item2));
		}

        public IPair<E1, E2> Power(IPair<E1, E2> l, IPair<E1, E2> r)
		{
            return new Pair<E1, E2>(Factory1.Power(l.Item1, r.Item1), Factory2.Power(l.Item2, r.Item2));
		}

        public IPair<E1, E2> Sum(string s)
        {
            return new Pair<E1, E2>(Factory1.Sum(s), Factory2.Sum(s));
        }

        public IPair<E1, E2> Average(string s)
        {
            return new Pair<E1, E2>(Factory1.Average(s), Factory2.Average(s));
        }

        public IPair<S1, S2> Forms(IPair<S1, S2> l, IPair<S1, S2> r)
        {
            return new Pair<S1, S2>(Factory1.Forms(l.Item1, r.Item1), Factory2.Forms(l.Item2, r.Item2));
        }

        public IPair<S1, S2> Goto()
        {
            return new Pair<S1, S2>(Factory1.Goto(), Factory2.Goto());
        }

        public IPair<S1, S2> Repeat(IPair<E1, E2> e, IPair<S1, S2> s)
		{
            return new Pair<S1, S2>(Factory1.Repeat(e.Item1, s.Item1), Factory2.Repeat(e.Item2, s.Item2));
		}
	}
}
