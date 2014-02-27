using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
	public class IfElseExpr : TernaryExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		private static readonly ITypeCheckType ExpressionUpperBound = new BoolType();
        public Tuple<int, int> SourcePosition { get; set; }

		public IfElseExpr(ITypeCheckExpr a, ITypeCheckExpr b, ITypeCheckExpr c)
            : base(a, b, c)
        {

        }

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            ITypeCheckType a = Expr1.TypeCheck(env, errRep);
			ITypeCheckType b = Expr2.TypeCheck(env, errRep);
			ITypeCheckType c = Expr3.TypeCheck(env, errRep);

			if (!a.CompatibleWith(ExpressionUpperBound))
			{
				errRep.ReportError(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
					a), SourcePosition);
			}

			if (!b.CompatibleWith(c))
			{
				errRep.ReportError(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
					b, c), SourcePosition);
			}

			return b.GetLeastUpperBound(c);
        }
    }
}
