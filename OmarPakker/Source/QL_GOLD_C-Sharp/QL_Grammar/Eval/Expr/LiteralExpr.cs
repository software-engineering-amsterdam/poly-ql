using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class LiteralExpr : LiteralExprNode, IEvalExpr
    {
        public LiteralExpr(IValue value)
            : base(value)
        {

        }

        public IValue Eval()
        {
            return Value;
        }
    }
}
