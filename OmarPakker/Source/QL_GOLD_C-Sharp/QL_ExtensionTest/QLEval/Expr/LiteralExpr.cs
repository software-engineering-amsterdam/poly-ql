using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class LiteralExpr : QL_Grammar.QLAlgebra.Expr.LiteralExpr, IEvalExpr
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
