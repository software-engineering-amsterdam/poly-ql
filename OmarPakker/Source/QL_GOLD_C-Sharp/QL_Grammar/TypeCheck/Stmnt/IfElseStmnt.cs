using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class IfElseStmnt : IfElseStmntNode<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
        public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

        public bool CheckTypesValid(out string msg)
        {
            if (!(CheckExpression.ExprType is BoolType))
            {
                msg = "Unable to evaluate 'if/else'. Expression must be of type bool!";
                return true;
            }

            msg = null;
            return false;
        }
	}
}
