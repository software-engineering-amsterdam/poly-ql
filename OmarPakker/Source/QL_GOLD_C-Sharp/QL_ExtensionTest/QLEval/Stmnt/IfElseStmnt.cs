using QL_ExtensionTest.QLEval.Expr;
using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<IEvalExpr, IEvalStmnt>, IEvalStmnt
	{
        public IfElseStmnt(IEvalExpr check, IEvalStmnt ifTrue, IEvalStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

		public void Eval()
		{
			if (((BoolValue)CheckExpression.Eval()).Value)
			{
				IfTrueBody.Eval();
			}
			else
			{
				IfFalseBody.Eval();
			}
		}
	}
}
