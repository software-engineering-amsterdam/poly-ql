using QL_ExtensionTest.QLTypeCheckExtensions.Stmnt;
using QL_Grammar.Check;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.Check
{
	public class CheckExtensionsStmnts : CheckStatements<CheckExtensionsExpressions>
	{
		public CheckExtensionsStmnts()
		{

		}

		protected override bool CheckStmnt(ITypeCheckStmnt stmnt)
		{
			return CheckStmnt((dynamic)stmnt);
		}

		protected bool CheckStmnt(LoopStmnt stmnt)
		{
			bool success = true;

			if (!(exprChecker.Check(stmnt.Expression) is IntType))
			{
                ReportError(stmnt.CreateTypeCheckError("Unable to evaluate 'loop'. Expression must be a integral type!",
					true));
				success = false;
			}

			return success && CheckStmnt(stmnt.Body);
		}
	}
}
