using System;
using Algebra.Core.Factory;
using Algebra.Core.Tree;
using Algebra.QL.Core.Factory;

namespace Algebra.QL.Extensions.Factory
{
    public class QLExtensionsFactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>
		: QLFactoryCombination<E1, S1, T1, E2, S2, T2, F1, F2>,
          IQLExtensionsFactory<CombinedExpr<E1, E2>, CombinedStmnt<S1, S2>, CombinedType<T1, T2>>
        where E1 : IExprNode
        where E2 : IExprNode
        where S1 : IStmntNode
        where S2 : IStmntNode
        where T1 : ITypeNode
        where T2 : ITypeNode
		where F1 : IQLExtensionsFactory<E1, S1, T1>
		where F2 : IQLExtensionsFactory<E2, S2, T2>
    {
        public QLExtensionsFactoryCombination(F1 f1, F2 f2)
            : base(f1, f2)
        {

        }

        public CombinedType<T1, T2> DateType()
        {
            return new CombinedType<T1, T2>(Factory1.DateType(), Factory2.DateType());
        }

        public CombinedExpr<E1, E2> Date(DateTime date)
		{
            return new CombinedExpr<E1, E2>(Factory1.Date(date), Factory2.Date(date));
		}

        public CombinedExpr<E1, E2> Modulo(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
            return new CombinedExpr<E1, E2>(Factory1.Modulo(l.Item1, r.Item1), Factory2.Modulo(l.Item2, r.Item2));
		}

        public CombinedExpr<E1, E2> Power(CombinedExpr<E1, E2> l, CombinedExpr<E1, E2> r)
		{
            return new CombinedExpr<E1, E2>(Factory1.Power(l.Item1, r.Item1), Factory2.Power(l.Item2, r.Item2));
		}

        public CombinedStmnt<S1, S2> Loop(CombinedExpr<E1, E2> e, CombinedStmnt<S1, S2> s)
		{
            return new CombinedStmnt<S1, S2>(Factory1.Loop(e.Item1, s.Item1), Factory2.Loop(e.Item2, s.Item2));
		}
	}
}
