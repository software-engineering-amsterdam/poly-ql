using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class IfElseExpr : TripleExpr<IEvalExpr>, IEvalExpr
    {
        public IfElseExpr(IEvalExpr a, IEvalExpr b, IEvalExpr c)
            : base(a, b, c)
        {

        }

        public IValue Eval()
        {
			if ((bool)Expr1.Eval().Value)
			{
				return Expr2.Eval();
			}
			else
			{
				return Expr3.Eval();
			}
        }
    }
}
