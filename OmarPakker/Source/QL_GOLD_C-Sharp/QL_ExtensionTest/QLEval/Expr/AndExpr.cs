using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class AndExpr : DoubleExpr<IEvalExpr>, IEvalExpr
	{
        public AndExpr(IEvalExpr l, IEvalExpr r)
            : base(l, r)
        {

        }

        public IValue Eval()
		{
			return new BoolValue(((BoolValue)Expr1.Eval()).Value
				&& ((BoolValue)Expr2.Eval()).Value);
		}
	}
}
