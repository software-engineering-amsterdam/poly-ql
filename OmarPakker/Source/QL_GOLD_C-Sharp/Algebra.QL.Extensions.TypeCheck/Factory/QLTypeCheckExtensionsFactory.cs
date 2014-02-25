using System;
using Algebra.Core.Type;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Type;
using Algebra.QL.Extensions.TypeCheck.Expr;
using Algebra.QL.Extensions.TypeCheck.Stmnt;
using Algebra.QL.Extensions.Value;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Factory
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
