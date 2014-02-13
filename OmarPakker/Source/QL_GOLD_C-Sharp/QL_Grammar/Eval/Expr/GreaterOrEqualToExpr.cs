using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

namespace QL_Grammar.Eval.Expr
{
    public class GreaterOrEqualToExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public GreaterOrEqualToExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

		public IValue Eval()
		{
			return new BoolValue(((IComparable)Expr1.Eval().Value)
				.CompareTo(Expr2.Eval().Value) >= 0);
		}
	}
}
