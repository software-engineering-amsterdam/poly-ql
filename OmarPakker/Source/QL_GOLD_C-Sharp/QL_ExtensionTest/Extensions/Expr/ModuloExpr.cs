using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLTypeCheck.Expr;

namespace QL_ExtensionTest.Extensions.Expr
{
    public class ModuloExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        public ModuloExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }
    }
}
