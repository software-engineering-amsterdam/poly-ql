using System;
using Algebra.Core.Type;
using Algebra.QL.Core.Expr;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public class IfElseExpr : TripleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		private readonly IType ExpressionUpperBound = new BoolType();

		public IfElseExpr(ITypeCheckExpr a, ITypeCheckExpr b, ITypeCheckExpr c)
            : base(a, b, c)
        {

        }

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
			IType b = Expr2.TypeCheck(data);
			IType c = Expr3.TypeCheck(data);

			if (!a.CompatibleWith(ExpressionUpperBound))
			{
				data.ReportError(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
					a), SourcePosition);
			}

			if (!b.CompatibleWith(c))
			{
				data.ReportError(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
					b, c), SourcePosition);
			}

			return b.GetLeastUpperBound(c);
        }
    }
}
