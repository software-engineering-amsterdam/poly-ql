using System;
using System.Linq;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Type;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class NegateExpr : SingleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		private readonly IType[] NegationUpperBoundTypes = { new BoolType(), new RealType() };

		public NegateExpr(ITypeCheckExpr e)
            : base(e)
		{
            
		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);

            if (!NegationUpperBoundTypes.Any(t => a.CompatibleWith(t)))
            {
                data.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only bool and numerical types are supported.",
                    a), SourcePosition);

                return new UnknownType();
            }

            return a;
        }
    }
}
