using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class OrExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public OrExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

        public IValue Eval()
		{
			IValue lEval = Left.Eval();
			IValue rEval = Right.Eval();

			if (lEval is BoolValue && rEval is BoolValue)
			{
				return new BoolValue(((BoolValue)lEval).Value || ((BoolValue)rEval).Value);
			}

			throw new InvalidOperationException("Unexpected Value in Or.");
		}
	}
}
