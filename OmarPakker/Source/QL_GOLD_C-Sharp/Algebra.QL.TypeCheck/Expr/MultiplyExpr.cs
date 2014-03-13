using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class MultiplyExpr : BinaryExpr, ITypeCheckExpr
	{
		private static readonly ITypeCheckType ExpressionUpperBound = new RealType();

		public MultiplyExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public override ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            ITypeCheckType a = Expr1.TypeCheck(env, errRep);
            ITypeCheckType b = Expr2.TypeCheck(env, errRep);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                errRep.ReportError(this, String.Format("Multiplication not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a, b));

                return ExpressionUpperBound;
            }

            return a.GetLeastUpperBound(b);
        }
	}
}
