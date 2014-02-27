using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class OrExpr : BinaryExpr<ITypeCheckExpr>, ITypeCheckExpr
	{
		private readonly ITypeCheckType ExpressionUpperBound = new BoolType();

		public OrExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
		{

		}

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            ITypeCheckType a = Expr1.TypeCheck(data);
            ITypeCheckType b = Expr2.TypeCheck(data);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                data.ReportError(String.Format("'||' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    a, b), SourcePosition);

				return ExpressionUpperBound;
            }

            return a.GetLeastUpperBound(b);
        }
    }
}
