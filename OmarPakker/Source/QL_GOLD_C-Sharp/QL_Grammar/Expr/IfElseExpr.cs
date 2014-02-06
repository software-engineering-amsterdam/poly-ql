using System;
using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class IfElseExpr<T> : IExpr
	{
		private readonly IExpr checkExpr;
		private readonly IExpr ifTrue;
		private readonly IExpr ifFalse;

		public IfElseExpr(IExpr expr, IExpr e1, IExpr e2)
		{
			checkExpr = expr;
			ifTrue = e1;
			ifFalse = e2;
		}

		public IValue Eval()
		{
			IValue checkValue = checkExpr.Eval();

			if (checkValue is BoolValue)
			{
				return ((BoolValue)checkValue).Value ? ifTrue.Eval() : ifFalse.Eval();
			}

			throw new InvalidOperationException("Unexpected Value in LessThen.");
		}
	}
}
