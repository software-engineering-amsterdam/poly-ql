using QL_ExtensionTest.Mathematics.Expr;
using QL_Grammar.Factory;
using QL_Grammar.TypeCheck.Expr;
using QL_Grammar.TypeCheck.Stmnt;

namespace QL_ExtensionTest.Mathematics.Factory
{
    public class MathFactory : TypeCheckFactory, IMathFactory<ITypeCheckExpr, ITypeCheckStmnt>
    {
        public ITypeCheckExpr Modulo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public ITypeCheckExpr Power(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new PowerExpr(l, r);
        }
    }
}
