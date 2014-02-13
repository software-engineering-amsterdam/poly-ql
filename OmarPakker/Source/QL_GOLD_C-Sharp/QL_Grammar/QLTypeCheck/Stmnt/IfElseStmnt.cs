using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Expr;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class IfElseStmnt : IfElseStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
		public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}
	}
}
