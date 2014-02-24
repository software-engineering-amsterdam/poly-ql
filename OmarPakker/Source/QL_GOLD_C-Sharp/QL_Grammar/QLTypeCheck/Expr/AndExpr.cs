using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Type;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class AndExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		private readonly IType ExpressionUpperBound = new BoolType();

		public AndExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("'&&' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    a, b), SourcePosition);

				return ExpressionUpperBound;
            }

			return a.GetLeastUpperBound(b);
        }
    }
}
