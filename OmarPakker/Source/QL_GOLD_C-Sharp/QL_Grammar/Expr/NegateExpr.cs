using System;
using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class NegateExpr : IExpr
	{
		private readonly IExpr a;

		public NegateExpr(IExpr value)
		{
			a = value;
		}

		public IValue Eval()
		{
			IValue eval = a.Eval();

			if (eval is IntValue)
			{
				return new IntValue(-((IntValue)eval).Value);
			}
			else if (eval is RealValue)
			{
				return new RealValue(-((RealValue)eval).Value);
			}
			else if (eval is BoolValue)
			{
				return new BoolValue(!((BoolValue)eval).Value);
			}

			throw new InvalidOperationException("Unexpected Value in Divide.");
		}
	}
}
