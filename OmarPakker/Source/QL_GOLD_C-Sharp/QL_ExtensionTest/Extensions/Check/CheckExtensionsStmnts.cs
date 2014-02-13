using QL_ExtensionTest.Extensions.Stmnt;
using QL_Grammar.Check;
using QL_Grammar.QLTypeCheck.Stmnt;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_ExtensionTest.Extensions.Check
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
				AddError("Unable to evaluate 'loop'. Expression must be a integral type!",
					true, stmnt.SourcePosition);
				success = false;
			}

			return success && CheckStmnt(stmnt.Body);
		}
	}
}
