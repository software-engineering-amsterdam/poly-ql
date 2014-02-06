using System;
using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class OrExpr : IExpr
	{
		private readonly IExpr l;
		private readonly IExpr r;

		public OrExpr(IExpr a, IExpr b)
		{
			l = a;
			r = b;
		}

		public IValue Eval()
		{
			IValue lEval = l.Eval();
			IValue rEval = r.Eval();

			if (lEval is BoolValue && rEval is BoolValue)
			{
				return new BoolValue(((BoolValue)lEval).Value || ((BoolValue)rEval).Value);
			}

			throw new InvalidOperationException("Unexpected Value in Or.");
		}
	}
}
