using System;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Value;
using QL_Grammar.Eval.Expr;

namespace QL_Grammar.Eval.Stmnt
{
    public class IfStmnt : IfStmntNode<IEvalExpr, IEvalStmnt>, IEvalStmnt
    {
        public IfStmnt(IEvalExpr check, IEvalStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

		public virtual void Eval()
		{
            IValue checkValue = CheckExpression.Eval();

			if (checkValue is BoolValue)
			{
				if(((BoolValue)checkValue).Value)
                {
                    IfTrueBody.Eval();
                }
			}
            else
            {
                throw new InvalidOperationException("Unexpected Value in If.");
            }
		}
    }
}
