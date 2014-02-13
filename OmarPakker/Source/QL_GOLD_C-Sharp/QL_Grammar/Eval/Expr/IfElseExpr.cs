using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class IfElseExpr : TripleExprNode<IEvalExpr>, IEvalExpr
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
