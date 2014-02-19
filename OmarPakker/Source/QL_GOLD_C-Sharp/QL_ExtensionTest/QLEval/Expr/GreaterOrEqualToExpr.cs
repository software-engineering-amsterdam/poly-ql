using System;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class GreaterOrEqualToExpr : DoubleExpr<IEvalExpr>, IEvalExpr
	{
		public GreaterOrEqualToExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

		public IValue Eval()
		{
			return new BoolValue(((IComparable)Expr1.Eval().Value)
				.CompareTo(Expr2.Eval().Value) >= 0);
		}
	}
}
