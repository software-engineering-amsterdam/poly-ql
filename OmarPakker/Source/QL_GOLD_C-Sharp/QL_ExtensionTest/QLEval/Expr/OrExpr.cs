using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class OrExpr : DoubleExpr<IEvalExpr>, IEvalExpr
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
