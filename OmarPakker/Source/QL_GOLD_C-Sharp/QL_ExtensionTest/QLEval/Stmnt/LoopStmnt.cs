using System;
using QL_ExtensionTest.QLEval.Expr;

namespace QL_ExtensionTest.QLEval.Stmnt
{
	public class LoopStmnt : IEvalStmnt
	{
		public Tuple<int, int> SourcePosition { get; set; }
		public IEvalExpr Expression { get; private set; }
        public IEvalStmnt Body { get; private set; }

        public LoopStmnt(IEvalExpr expr, IEvalStmnt body)
		{
			Expression = expr;
			Body = body;
		}

        public void Eval()
        {
            for (int i = 0; i < (int)Expression.Eval().Value; i++)
            {
                Body.Eval();
            }
        }
    }
}
