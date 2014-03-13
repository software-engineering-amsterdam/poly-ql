using System;

namespace Algebra.QL.Extensions.Factory
{
    public class ExtFactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>
		: Algebra.QL.Core.Factory.FactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>,
          IExtFactory<Tuple<E1, E2>, Tuple<S1, S2>, Tuple<T1, T2>>
		where F1 : IExtFactory<E1, S1, T1>
		where F2 : IExtFactory<E2, S2, T2>
    {
        public ExtFactoryCombination(F1 f1, F2 f2)
            : base(f1, f2)
        {

        }

        public Tuple<T1, T2> DateType()
        {
            return new Tuple<T1, T2>(Factory1.DateType(), Factory2.DateType());
        }

        public Tuple<E1, E2> Date(DateTime date)
		{
            return new Tuple<E1, E2>(Factory1.Date(date), Factory2.Date(date));
		}

        public Tuple<E1, E2> Modulo(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
            return new Tuple<E1, E2>(Factory1.Modulo(l.Item1, r.Item1), Factory2.Modulo(l.Item2, r.Item2));
		}

        public Tuple<E1, E2> Power(Tuple<E1, E2> l, Tuple<E1, E2> r)
		{
            return new Tuple<E1, E2>(Factory1.Power(l.Item1, r.Item1), Factory2.Power(l.Item2, r.Item2));
		}

        public Tuple<S1, S2> Forms(Tuple<S1, S2> l, Tuple<S1, S2> r)
        {
            return new Tuple<S1, S2>(Factory1.Forms(l.Item1, r.Item1), Factory2.Forms(l.Item2, r.Item2));
        }

        public Tuple<S1, S2> Goto()
        {
            return new Tuple<S1, S2>(Factory1.Goto(), Factory2.Goto());
        }

        public Tuple<S1, S2> Loop(Tuple<E1, E2> e, Tuple<S1, S2> s)
		{
            return new Tuple<S1, S2>(Factory1.Loop(e.Item1, s.Item1), Factory2.Loop(e.Item2, s.Item2));
		}
	}
}
