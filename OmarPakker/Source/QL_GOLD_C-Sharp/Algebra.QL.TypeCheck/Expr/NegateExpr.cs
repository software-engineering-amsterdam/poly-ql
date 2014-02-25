using System;
using Algebra.Core.Type;
using Algebra.QL.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class NegateExpr : SingleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
        private readonly IType NegationUpperBound;

		public NegateExpr(IType negationUpperBound, ITypeCheckExpr e)
            : base(e)
		{
            NegationUpperBound = negationUpperBound;
		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);

            if (!a.CompatibleWith(NegationUpperBound))
            {
                data.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only bool and numerical types are supported.",
                    a), SourcePosition);

                return NegationUpperBound;
            }

            return a;
        }
    }
}
