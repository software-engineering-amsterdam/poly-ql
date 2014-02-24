using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Type;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class DivideExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		private readonly IType ExpressionUpperBound = new RealType();

		public DivideExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{
			
		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

			if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Division not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a, b), SourcePosition);

                return ExpressionUpperBound;
            }

            return a.GetLeastUpperBound(b);
        }
    }
}
