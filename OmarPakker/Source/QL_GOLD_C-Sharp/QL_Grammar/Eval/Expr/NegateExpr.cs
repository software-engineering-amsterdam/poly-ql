using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
	public class NegateExpr : SingleExprNode<IEvalExpr>, IEvalExpr
	{
		public NegateExpr(IEvalExpr e)
            : base(e)
		{
            
		}

		public IValue Eval()
		{
			IValue eval = Expression.Eval();

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
