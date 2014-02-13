using QL_Grammar.AST.Stmnt;
using QL_Grammar.Eval.Expr;
using QL_Grammar.QL.Value;

namespace QL_Grammar.Eval.Stmnt
{
    public class IfElseStmnt : IfElseStmntNode<IEvalExpr, IEvalStmnt>, IEvalStmnt
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
