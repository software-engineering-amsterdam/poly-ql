using System;
using System.Collections.Generic;
using QL_Grammar.QLTypeCheck.Stmnt;
using QL_Grammar.QLTypeCheck.Types;

namespace QL_Grammar.Check
{
	public class CheckStatements<E>
		where E : CheckExpressions, new()
	{
		private AddErrorDelegate addError;
		public AddErrorDelegate AddError
		{
			get { return addError; }
			internal set
			{
				addError = exprChecker.AddError = value;
			}
		}

		protected HashSet<string> forms { get; private set; }
		protected List<GotoStmnt> gotos { get; private set; }
		protected E exprChecker { get; private set; }

		public CheckStatements()
		{
			forms = new HashSet<string>();
			gotos = new List<GotoStmnt>();
			exprChecker = new E();
		}

		public void Check(ITypeCheckStmnt stmnt)
		{
			CheckStmnt(stmnt);

			gotos.RemoveAll((item) => forms.Contains(item.GotoName));

			foreach (GotoStmnt item in gotos)
			{
				AddError(String.Format("'goto' statement not possible. Form {0} does not exist!",
					item.GotoName), true, item.SourcePosition);
			}
		}

		protected virtual bool CheckStmnt(ITypeCheckStmnt stmnt)
		{
			return CheckStmnt((dynamic)stmnt);
		}

		protected bool CheckStmnt(CompStmnt stmnt)
		{
			bool success = true;

			foreach (ITypeCheckStmnt item in stmnt.Statements)
			{
				if (!CheckStmnt(item))
				{
					success = false;
				}
			}

			return success;
		}

		protected bool CheckStmnt(FormStmnt stmnt)
		{
			forms.Add(stmnt.Name);

			exprChecker.ClearVariables();

			return CheckStmnt(stmnt.Body);
		}

		protected bool CheckStmnt(GotoStmnt stmnt)
		{
			if (gotos.Exists((item) => item.GotoName.Equals(stmnt.GotoName)))
			{
				AddError(String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
					stmnt.GotoName), false, stmnt.SourcePosition);
			}

			gotos.Add(stmnt);

			return true;
		}

		protected bool CheckStmnt(QuestionStmnt stmnt)
		{
			exprChecker.Check(stmnt.Expression);

			if (String.IsNullOrWhiteSpace(stmnt.QuestionText))
			{
				AddError("Empty question detected. Are you sure you want to leave this question blank?",
					false, stmnt.SourcePosition);
			}

			return true;
		}

		protected bool CheckStmnt(IfStmnt stmnt)
		{
			bool success = true;

			if (!(exprChecker.Check(stmnt.CheckExpression) is BoolType))
			{
				AddError("Unable to evaluate 'if'. Expression must be of type bool!",
					true, stmnt.SourcePosition);
				success = false;
			}

			return success && CheckStmnt(stmnt.IfTrueBody);
		}

		protected bool CheckStmnt(IfElseStmnt stmnt)
		{
			bool success = true;

			if (!(exprChecker.Check(stmnt.CheckExpression) is BoolType))
			{
				AddError("Unable to evaluate 'if/else'. Expression must be of type bool!",
					true, stmnt.SourcePosition);
				success = false;
			}

			return success && CheckStmnt(stmnt.IfTrueBody) && CheckStmnt(stmnt.IfFalseBody);
		}
	}
}
