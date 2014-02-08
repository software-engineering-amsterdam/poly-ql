using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class SubtractExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public SubtractExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

        public IValue Eval()
		{
			IValue lEval = Expr1.Eval();
			IValue rEval = Expr2.Eval();

			if (lEval is IntValue && rEval is IntValue)
			{
				return new IntValue(((IntValue)lEval).Value - ((IntValue)rEval).Value);
			}
			else if (lEval is RealValue && rEval is RealValue)
			{
				return new RealValue(((RealValue)lEval).Value - ((RealValue)rEval).Value);
			}
			else if (lEval is IntValue && rEval is RealValue)
			{
				return new RealValue(((IntValue)lEval).Value - ((RealValue)rEval).Value);
			}
			else if (lEval is RealValue && rEval is IntValue)
			{
				return new RealValue(((RealValue)lEval).Value - ((IntValue)rEval).Value);
			}

			throw new InvalidOperationException("Unexpected Value in Subtract.");
		}
	}
}
