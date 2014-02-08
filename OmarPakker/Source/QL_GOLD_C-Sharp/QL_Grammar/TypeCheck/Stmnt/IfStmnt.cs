using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class IfStmnt : IfStmntNode<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public bool CheckTypesValid(out string msg)
        {
            if (!(CheckExpression.ExprType is BoolType))
            {
                msg = "Unable to evaluate 'if'. Expression must be of type bool!";
                return true;
            }

            msg = null;
            return false;
        }
    }
}
