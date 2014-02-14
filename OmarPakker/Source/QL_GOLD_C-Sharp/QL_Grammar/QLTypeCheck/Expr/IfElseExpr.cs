using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class IfElseExpr : TripleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public IfElseExpr(ITypeCheckExpr a, ITypeCheckExpr b, ITypeCheckExpr c)
            : base(a, b, c)
        {

        }

        public IType TypeCheck(TypeCheckData data)
        {
            IType a = Expr1.TypeCheck(data);
			IType b = Expr2.TypeCheck(data);
			IType c = Expr3.TypeCheck(data);

			if (!(a is BoolType))
			{
				data.ReportError(String.Format("Inline 'if/else' evaluation failed. Incompatible type: '{0}'. Only the bool type is supported.",
					a.ToString()), SourcePosition);
			}

			if (!b.CompatibleWith(c))
			{
				data.ReportError(String.Format("Inline 'if/else' return value conflict. Incompatible types: '{0}', '{1}'. Only similar types can be used in the true/false bodies.",
					b.ToString(), c.ToString()), SourcePosition);
			}

			return b.CompatibleWith(c) ? ((a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance)
				: UnknownType.Instance;
        }
    }
}
