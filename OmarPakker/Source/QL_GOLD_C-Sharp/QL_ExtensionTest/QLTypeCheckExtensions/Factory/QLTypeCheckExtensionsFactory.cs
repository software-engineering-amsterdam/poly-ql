using System;
using QL_ExtensionTest.QLAlgebraExtensions.Factory;
using QL_ExtensionTest.QLAlgebraExtensions.Type;
using QL_ExtensionTest.QLAlgebraExtensions.Value;
using QL_ExtensionTest.QLTypeCheckExtensions.Expr;
using QL_ExtensionTest.QLTypeCheckExtensions.Stmnt;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Factory;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.QLTypeCheckExtensions.Factory
{
	public class QLTypeCheckExtensionsFactory : QLTypeCheckFactory, IQLExtensionsFactory<ITypeCheckExpr, ITypeCheckStmnt>
    {
		public IType DateType()
		{
			return new DateType();
		}

		public ITypeCheckExpr Date(DateTime date)
		{
			return Literal(new DateValue(date));
		}

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
