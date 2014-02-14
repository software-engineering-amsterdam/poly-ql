using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class LessOrEqualToExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public LessOrEqualToExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

            if (!(a is NumericType) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Comparison using '<=' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a.ToString(), b.ToString()), SourcePosition);
            }

            return BoolType.Instance;
        }
    }
}
