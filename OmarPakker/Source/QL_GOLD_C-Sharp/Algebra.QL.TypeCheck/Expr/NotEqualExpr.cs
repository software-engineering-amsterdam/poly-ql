using System;
using Algebra.Core.Type;
using Algebra.QL.Core.Expr;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class NotEqualExpr : BinaryExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		public NotEqualExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

            if (!a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Comparison using '!=' not possible. Incompatible types: '{0}', '{1}'.",
                    a, b), SourcePosition);
            }

            return new BoolType();
        }
    }
}
