using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class NotEqualExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public NotEqualExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

        public IValue Eval()
		{
			return new BoolValue(!Left.Eval().Value.Equals(Right.Eval().Value));
		}
	}
}
