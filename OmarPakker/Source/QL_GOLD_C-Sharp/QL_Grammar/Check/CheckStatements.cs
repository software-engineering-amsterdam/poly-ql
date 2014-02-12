using System;
using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.QL.Stmnt;

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

		public List<Tuple<string, GotoStmntNode>> Gotos { get; private set; }
		protected E exprChecker { get; private set; }

		public CheckStatements()
		{
			Gotos = new List<Tuple<string, GotoStmntNode>>();
			exprChecker = new E();
		}

		public virtual bool CheckStmnt(IStmntNode stmnt)
		{
			return CheckStmnt((dynamic)stmnt);
		}

		protected bool CheckStmnt(CompStmnt stmnt)
		{
			bool success = true;

			foreach (IStmntNode item in stmnt.Statements)
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
			Gotos.RemoveAll((item) => item.Item1.Equals(stmnt.Name));
			
			exprChecker.Variables.Clear();

			return CheckStmnt(stmnt.Body);
		}

		protected bool CheckStmnt(GotoStmnt stmnt)
		{
			if (Gotos.Exists((item) => item.Item1.Equals(stmnt.GotoName)))
			{
				AddError(String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
					stmnt.GotoName), false, stmnt.SourcePosition);
			}

			Gotos.Add(new Tuple<string, GotoStmntNode>(stmnt.GotoName, stmnt));

			return true;
		}

		protected bool CheckStmnt(QuestionStmnt stmnt)
		{
			exprChecker.CheckExpr((dynamic)stmnt.Expression);

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

			if (!(exprChecker.CheckExpr((dynamic)stmnt.CheckExpression) is BoolType))
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

			if (!(exprChecker.CheckExpr((dynamic)stmnt.CheckExpression) is BoolType))
			{
				AddError("Unable to evaluate 'if/else'. Expression must be of type bool!",
					true, stmnt.SourcePosition);
				success = false;
			}

			return success && CheckStmnt(stmnt.IfTrueBody) && CheckStmnt(stmnt.IfFalseBody);
		}
	}
}
