using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public class LiteralExpr : QL_Grammar.QLAlgebra.Expr.LiteralExpr, IPrintExpr
    {
        public LiteralExpr(IValue value)
            : base(value)
        {

        }

        public string BuildDocument()
        {
            return Value.ToString();
        }
    }
}
