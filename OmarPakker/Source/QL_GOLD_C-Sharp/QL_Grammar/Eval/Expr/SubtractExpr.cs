using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

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

			if (lEval is RealValue || rEval is RealValue)
			{
				return new RealValue((double)lEval.Value - (double)rEval.Value);
			}
			else
			{
				return new IntValue((int)lEval.Value - (int)rEval.Value);
			}
		}
	}
}
