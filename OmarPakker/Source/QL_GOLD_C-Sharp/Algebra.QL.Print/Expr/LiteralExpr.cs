using Algebra.Core.Value;

namespace Algebra.QL.Print.Expr
{
    public class LiteralExpr : Algebra.QL.Core.Expr.LiteralExpr, IPrintExpr
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
