using System;
using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class DivideExpr : IExpr
	{
		private readonly IExpr l;
		private readonly IExpr r;

		public DivideExpr(IExpr a, IExpr b)
		{
			l = a;
			r = b;
		}

		public IValue Eval()
		{
			IValue lEval = l.Eval();
			IValue rEval = r.Eval();

			if (lEval is IntValue && rEval is IntValue)
			{
				return new IntValue(((IntValue)lEval).Value / ((IntValue)rEval).Value);
			}
			else if (lEval is RealValue && rEval is RealValue)
			{
				return new RealValue(((RealValue)lEval).Value / ((RealValue)rEval).Value);
			}
			else if (lEval is IntValue && rEval is RealValue)
			{
				return new RealValue(((IntValue)lEval).Value / ((RealValue)rEval).Value);
			}
			else if (lEval is RealValue && rEval is IntValue)
			{
				return new RealValue(((RealValue)lEval).Value / ((IntValue)rEval).Value);
			}

			throw new InvalidOperationException("Unexpected Value in Divide.");
		}
	}
}
