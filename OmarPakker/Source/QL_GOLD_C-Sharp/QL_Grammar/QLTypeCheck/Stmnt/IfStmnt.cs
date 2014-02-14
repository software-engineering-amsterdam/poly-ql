using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public void TypeCheck(TypeCheckData data)
        {
            if (!(CheckExpression.TypeCheck(data) is BoolType))
            {
                data.ReportError("Unable to evaluate 'if'. Expression must be of type bool!",
                    SourcePosition);
            }

            IfTrueBody.TypeCheck(data);
        }
    }
}
