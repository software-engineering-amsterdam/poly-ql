using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class EqualsExpr : DoubleExpr<IEvalExpr>, IEvalExpr
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
