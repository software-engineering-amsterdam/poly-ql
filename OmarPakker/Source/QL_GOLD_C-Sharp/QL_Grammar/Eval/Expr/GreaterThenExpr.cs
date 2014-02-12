using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class GreaterThenExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public GreaterThenExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

        public IValue Eval()
		{
			object lEval = Expr1.Eval().Value;
            object rEval = Expr2.Eval().Value;

			if (lEval is IComparable && rEval is IComparable)
			{
				return new BoolValue(((IComparable)lEval).CompareTo(rEval) > 0);
			}

			throw new InvalidOperationException("Unexpected Value in GreaterThen.");
		}
	}
}
