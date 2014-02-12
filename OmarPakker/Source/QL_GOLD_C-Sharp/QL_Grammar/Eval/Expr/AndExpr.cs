using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class AndExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
        public AndExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        public IValue Eval()
		{
			IValue lEval = Expr1.Eval();
			IValue rEval = Expr2.Eval();

			if (lEval is BoolValue && rEval is BoolValue)
			{
				return new BoolValue(((BoolValue)lEval).Value && ((BoolValue)rEval).Value);
			}
			
			throw new InvalidOperationException("Unexpected Value in And.");
		}
	}
}
