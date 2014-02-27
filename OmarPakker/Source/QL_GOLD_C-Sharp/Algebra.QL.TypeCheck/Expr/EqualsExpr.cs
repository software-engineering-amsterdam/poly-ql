using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class EqualsExpr : BinaryExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public EqualsExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            ITypeCheckType a = Expr1.TypeCheck(data);
            ITypeCheckType b = Expr2.TypeCheck(data);

            if (!a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Comparison using '==' not possible. Incompatible types: '{0}', '{1}'.",
                    a, b), SourcePosition);
            }

            return new BoolType();
        }
    }
}
