using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class AddExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public AddExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

            if (!(a is NumericType) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Addition not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a.ToString(), b.ToString()), SourcePosition);

                return NumericType.Instance;
            }

            return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
        }
    }
}
