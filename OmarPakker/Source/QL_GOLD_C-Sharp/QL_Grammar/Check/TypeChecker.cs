using System;
using System.Collections.Generic;
using QL_Grammar.AST;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Check
{
	public delegate void AddErrorDelegate(string msg, bool error, Tuple<int, int> pos);

	public class TypeChecker<E, S>
		where E : CheckExpressions, new()
		where S : CheckStatements<E>, new()
	{
		public bool HasErrors { get { return Errors.Count > 1; } }
		public IReadOnlyList<Tuple<string, bool>> Errors { get { return errors; } }
		private List<Tuple<string, bool>> errors;

		public TypeChecker()
		{
			errors = new List<Tuple<string, bool>>();
		}

		public void AddError(string msg, bool error, Tuple<int, int> pos)
		{
			string finalMsg = (error ? "ERROR! " : "WARNING! ") + msg;
			if (pos != null)
			{
				finalMsg += String.Format(" (line {0} column {1}).",
					//Line/column properties start on 0 so offset it to correct that.
					//Column points to the character index at the end of the statement.
					pos.Item1 + 1, pos.Item2 + 1);
			}

			errors.Add(new Tuple<string, bool>(finalMsg, error));
		}

		public bool Check(IASTNode rootNode)
		{
			Check((dynamic)rootNode);
			return HasErrors;
		}

		private void Check(IExprNode expr)
		{
			E exprChecker = new E();
			exprChecker.AddError = AddError;
			exprChecker.CheckExpr(expr);
		}

		private void Check(IStmntNode stmnt)
		{
			S stmntChecker = new S();
			stmntChecker.AddError = AddError;
			stmntChecker.CheckStmnt(stmnt);

			foreach (Tuple<string, GotoStmntNode> item in stmntChecker.Gotos)
			{
				AddError(String.Format("'goto' statement not possible. Form {0} does not exist!",
					item.Item2.GotoName), true, item.Item2.SourcePosition);
			}
		}
	}
}
