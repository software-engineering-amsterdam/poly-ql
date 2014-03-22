using System;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.TypeCheck.Expr;
using Algebra.QL.Extensions.TypeCheck.Expr.Literals;
using Algebra.QL.Extensions.TypeCheck.Stmnt;
using Algebra.QL.Extensions.TypeCheck.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Factory
{
    public class ExtTypeCheckFactory : TypeCheckFactory, IStmntFactory<ITypeCheckStmnt, ITypeCheckExpr, ITypeCheckType>
    {
        public ExtTypeCheckFactory()
        {

        }

        public ITypeCheckType DateType()
        {
            return new DateType();
        }

		public ITypeCheckExpr Date(DateTime date)
		{
            return new DateLiteral(date);
		}

        public ITypeCheckExpr Modulo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public ITypeCheckExpr Power(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new PowerExpr(l, r);
        }

        public ITypeCheckStmnt Forms(ITypeCheckStmnt l, ITypeCheckStmnt r)
        {
            return new FormsStmnt(l, r);
        }

        public ITypeCheckStmnt Goto()
        {
            return new GotoStmnt();
        }

		public ITypeCheckStmnt Repeat(ITypeCheckExpr e, ITypeCheckStmnt s)
		{
			return new RepeatStmnt(e, s);
		}

        public ITypeCheckExpr Sum(string s)
        {
            return new SumExpr(s);
        }

        public ITypeCheckExpr Average(string s)
        {
            return new AvgExpr(s);
        }
    }
}
