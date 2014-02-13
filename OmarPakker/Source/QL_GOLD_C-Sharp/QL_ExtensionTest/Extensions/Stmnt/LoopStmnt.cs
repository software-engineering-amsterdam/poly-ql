using System;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;

namespace QL_ExtensionTest.Extensions.Stmnt
{
	public class LoopStmnt : IStmntNode
	{
		public Tuple<int, int> SourcePosition { get; set; }
		public IExprNode Expression { get; private set; }
		public IStmntNode Body { get; private set; }

		public LoopStmnt(IExprNode expr, IStmntNode body)
		{
			Expression = expr;
			Body = body;
		}
	}
}
