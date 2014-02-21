using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
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
