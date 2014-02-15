using System;
using QL_Grammar.QLAlgebra.Factory;

namespace QL_ExtensionTest.QLAlgebraExtensions.Factory
{
    public class QLExtensionsFactoryCombination<F1E, F1S, F2E, F2S, F1, F2>
        : QLFactoryCombination<F1E, F1S, F2E, F2S, F1, F2>, IQLExtensionsFactory<Tuple<F1E, F2E>, Tuple<F1S, F2S>>
        where F1 : IQLExtensionsFactory<F1E, F1S>
        where F2 : IQLExtensionsFactory<F2E, F2S>
    {
        public QLExtensionsFactoryCombination(F1 f1, F2 f2)
            : base(f1, f2)
        {

        }

        public Tuple<F1E, F2E> Modulo(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
        {
            return new Tuple<F1E, F2E>(Factory1.Modulo(l.Item1, r.Item1), Factory2.Modulo(l.Item2, r.Item2));
        }
        
        public Tuple<F1E, F2E> Power(Tuple<F1E, F2E> l, Tuple<F1E, F2E> r)
        {
            return new Tuple<F1E, F2E>(Factory1.Power(l.Item1, r.Item1), Factory2.Power(l.Item2, r.Item2));
        }

        public Tuple<F1S, F2S> Loop(Tuple<F1E, F2E> e, Tuple<F1S, F2S> s)
        {
            return new Tuple<F1S, F2S>(Factory1.Loop(e.Item1, s.Item1), Factory2.Loop(e.Item2, s.Item2));
        }
    }
}
