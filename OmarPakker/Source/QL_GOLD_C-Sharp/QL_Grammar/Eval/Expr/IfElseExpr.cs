using System;
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
            object aEval = Expr1.Eval().Value;

            if (aEval is bool)
            {
                if ((bool)aEval)
                {
                    return Expr2.Eval();
                }
                else
                {
                    return Expr3.Eval();
                }
            }

            throw new InvalidOperationException("Unexpected Value in GreaterThen.");
        }
    }
}
