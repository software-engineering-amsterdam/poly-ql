using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class OrExpr : BinaryExpr, ITypeCheckExpr
	{
		private static readonly ITypeCheckType ExpressionUpperBound = new BoolType();

		public OrExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            ITypeCheckType a = Expr1.TypeCheck(env, errRep);
            ITypeCheckType b = Expr2.TypeCheck(env, errRep);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                errRep.ReportError(this, String.Format("'||' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    a, b));

				return ExpressionUpperBound;
            }

            return a.GetLeastUpperBound(b);
        }
    }
}
