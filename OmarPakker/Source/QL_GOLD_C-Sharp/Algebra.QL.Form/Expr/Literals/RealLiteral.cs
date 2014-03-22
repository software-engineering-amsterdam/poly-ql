using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public class RealLiteral : LiteralExpr<double>, IFormExpr
    {
        public override IFormType Type { get { return new RealType(); } }

        public RealLiteral(double value)
            : base(value)
        {

        }
    }
}
