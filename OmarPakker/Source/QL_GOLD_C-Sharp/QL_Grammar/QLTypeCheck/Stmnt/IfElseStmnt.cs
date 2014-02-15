using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class IfElseStmnt : IfElseStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
		public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

        public void TypeCheck(TypeCheckData data)
        {
            if (!(CheckExpression.TypeCheck(data) is BoolType))
            {
                data.ReportError("Unable to evaluate 'if/else'. Expression must be of type bool!",
                    SourcePosition);
            }

            IfTrueBody.TypeCheck(data);
            IfFalseBody.TypeCheck(data);
        }
    }
}
