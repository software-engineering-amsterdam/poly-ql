using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

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
			return new BoolValue(((BoolValue)Expr1.Eval()).Value
				|| ((BoolValue)Expr2.Eval()).Value);
		}
	}
}
