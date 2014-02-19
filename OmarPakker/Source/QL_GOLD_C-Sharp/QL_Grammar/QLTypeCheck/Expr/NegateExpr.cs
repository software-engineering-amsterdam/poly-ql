using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class NegateExpr : SingleExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public NegateExpr(ITypeCheckExpr e)
            : base(e)
		{
            
		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);

            if (!(a is BoolType || a is NumericType))
            {
                data.ReportError(String.Format("Negation not possible. Incompatible type: '{0}', Only bool and numerical types are supported.",
                    a.ToString()), SourcePosition);

                return UnknownType.Instance;
            }

            return a;
        }
    }
}
