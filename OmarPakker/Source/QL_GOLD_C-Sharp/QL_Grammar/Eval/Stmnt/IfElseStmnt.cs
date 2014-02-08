using System;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Value;
using QL_Grammar.Eval.Expr;

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
			IValue checkValue = CheckExpression.Eval();

			if (checkValue is BoolValue)
			{
				if(((BoolValue)checkValue).Value)
                {
                    IfTrueBody.Eval();
                }
                else
                {
                    IfFalseBody.Eval();
                }
			}
            else
            {
                throw new InvalidOperationException("Unexpected Value in IfElse.");
            }
		}
	}
}
