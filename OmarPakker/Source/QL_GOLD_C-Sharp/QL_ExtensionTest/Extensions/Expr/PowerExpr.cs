using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLTypeCheck.Expr;

namespace QL_ExtensionTest.Extensions.Expr
{
    public class PowerExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        public PowerExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }
    }
}
