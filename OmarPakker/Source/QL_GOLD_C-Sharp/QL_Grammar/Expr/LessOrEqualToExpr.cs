using System;
using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class LessOrEqualToExpr : IExpr
	{
		private readonly IExpr l;
		private readonly IExpr r;

		public LessOrEqualToExpr(IExpr a, IExpr b)
		{
			l = a;
			r = b;
		}

		public IValue Eval()
		{
			IValue lEval = l.Eval();
			IValue rEval = r.Eval();

			if (lEval is IComparable && rEval is IComparable)
			{
				return new BoolValue(((IComparable)lEval.Value).CompareTo(rEval.Value) <= 0);
			}

			throw new InvalidOperationException("Unexpected Value in LessThen.");
		}
	}
}
