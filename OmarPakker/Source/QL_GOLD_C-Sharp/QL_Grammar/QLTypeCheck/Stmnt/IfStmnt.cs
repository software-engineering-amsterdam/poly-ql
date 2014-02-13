using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLTypeCheck.Expr;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}
    }
}
