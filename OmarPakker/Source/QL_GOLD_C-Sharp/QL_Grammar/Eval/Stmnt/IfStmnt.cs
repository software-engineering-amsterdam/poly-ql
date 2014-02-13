using QL_Grammar.AST.Stmnt;
using QL_Grammar.Eval.Expr;
using QL_Grammar.QL.Value;

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
			if (((BoolValue)CheckExpression.Eval()).Value)
			{
				IfTrueBody.Eval();
			}
		}
    }
}
