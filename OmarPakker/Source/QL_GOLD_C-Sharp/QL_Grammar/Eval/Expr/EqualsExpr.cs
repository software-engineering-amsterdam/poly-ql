using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Value;

namespace QL_Grammar.Eval.Expr
{
    public class EqualsExpr : DoubleExprNode<IEvalExpr>, IEvalExpr
	{
		public EqualsExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
		{

		}

		public IValue Eval()
		{
			return new BoolValue(Expr1.Eval().Value.Equals(Expr2.Eval().Value));
		}
	}
}
