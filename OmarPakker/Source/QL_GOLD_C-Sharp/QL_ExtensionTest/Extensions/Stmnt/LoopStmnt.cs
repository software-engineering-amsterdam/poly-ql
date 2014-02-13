using System;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.Extensions.Stmnt
{
	public class LoopStmnt : ITypeCheckStmnt
	{
		public Tuple<int, int> SourcePosition { get; set; }
		public ITypeCheckExpr Expression { get; private set; }
		public ITypeCheckStmnt Body { get; private set; }

		public LoopStmnt(ITypeCheckExpr expr, ITypeCheckStmnt body)
		{
			Expression = expr;
			Body = body;
		}
	}
}
