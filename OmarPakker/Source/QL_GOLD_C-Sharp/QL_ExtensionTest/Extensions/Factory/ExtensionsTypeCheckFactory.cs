using QL_ExtensionTest.Extensions.Expr;
using QL_ExtensionTest.Extensions.Stmnt;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Factory;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.Extensions.Factory
{
	public class ExtensionsTypeCheckFactory : QLTypeCheckFactory, IExtensionsFactory<ITypeCheckExpr, ITypeCheckStmnt>
    {
        public ITypeCheckExpr Modulo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public ITypeCheckExpr Power(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new PowerExpr(l, r);
        }

		public ITypeCheckStmnt Loop(ITypeCheckExpr e, ITypeCheckStmnt s)
		{
			return new LoopStmnt(e, s);
		}
    }
}
