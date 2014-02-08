using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class LessThenExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public LessThenExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

        public IValue Eval()
		{
			object lEval = Left.Eval().Value;
            object rEval = Right.Eval().Value;

			if (lEval is IComparable && rEval is IComparable)
			{
				return new BoolValue(((IComparable)lEval).CompareTo(rEval) < 0 );
			}

			throw new InvalidOperationException("Unexpected Value in LessThen.");
		}
	}
}
