using System;
using Algebra.Core.Type;
using Algebra.QL.Core.Expr;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class LessOrEqualToExpr : BinaryExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		private readonly IType ExpressionUpperBound = new RealType();

		public LessOrEqualToExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
            IType b = Expr2.TypeCheck(data);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("Comparison using '<=' not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
                    a, b), SourcePosition);
            }

            return new BoolType();
        }
    }
}
