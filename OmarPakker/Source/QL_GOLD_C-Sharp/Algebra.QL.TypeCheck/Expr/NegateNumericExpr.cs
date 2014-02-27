using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class NegateNumericExpr : UnaryExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
        private readonly ITypeCheckType NegationUpperBound = new RealType();

		public NegateNumericExpr(ITypeCheckExpr e)
            : base(e)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            ITypeCheckType a = Expr1.TypeCheck(data);

            if (!a.CompatibleWith(NegationUpperBound))
            {
                data.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only numerical types are supported.",
                    a), SourcePosition);

                return NegationUpperBound;
            }

            return a;
        }
    }
}
