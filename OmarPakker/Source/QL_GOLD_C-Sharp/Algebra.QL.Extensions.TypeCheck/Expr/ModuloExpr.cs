using System;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Expr
{
    public class ModuloExpr : BinaryExpr, ITypeCheckExpr
    {
        private static readonly ITypeCheckType ExpressionUpperBound = new RealType();

        public ModuloExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
		{
            ITypeCheckType a = Expr1.TypeCheck(env, errRep);
            ITypeCheckType b = Expr2.TypeCheck(env, errRep);

			if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
			{
				errRep.ReportError(this, String.Format("Modulo not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
					a, b));

				return ExpressionUpperBound;
			}

			return a.GetLeastUpperBound(b);
		}
	}
}
