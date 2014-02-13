using System;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_Grammar.Check
{
    public delegate void OnTypeCheckErrorEventHandler(Tuple<string, bool> error);

	public sealed class TypeChecker<E, S>
		where E : CheckExpressions, new()
		where S : CheckStatements<E>, new()
	{
        public delegate void OnTypeCheckErrorEventHandler(string msg, bool error);
        public event OnTypeCheckErrorEventHandler OnTypeCheckError;

		public TypeChecker()
		{

		}

		internal void ReportError(Tuple<string, bool> error)
		{
			if(OnTypeCheckError != null)
            {
                OnTypeCheckError(error.Item1, error.Item2);
            }
		}

		public void Check(object root)
		{
			Check((dynamic)root);
		}

		private void Check(ITypeCheckExpr expr)
		{
			E exprChecker = new E();
            exprChecker.ReportError = ReportError;
			exprChecker.Check(expr);
		}

		private void Check(ITypeCheckStmnt stmnt)
		{
			S stmntChecker = new S();
            stmntChecker.ReportError = ReportError;
			stmntChecker.Check(stmnt);
		}
	}
}
