using System;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
	public class NegateExpr : SingleExpr<IEvalExpr>, IEvalExpr
	{
		public NegateExpr(IEvalExpr e)
            : base(e)
		{
            
		}

		public IValue Eval()
		{
			IValue eval = Expr1.Eval();

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
