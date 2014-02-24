using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLAlgebra.Type;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
		private readonly IType ExpressionType = new BoolType();

		public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public void TypeCheck(TypeCheckData data)
        {
            if (!CheckExpression.TypeCheck(data).CompatibleWith(ExpressionType))
            {
                data.ReportError("Unable to evaluate 'if'. Expression must be of type bool!",
                    SourcePosition);
            }

            IfTrueBody.TypeCheck(data);
        }
    }
}
