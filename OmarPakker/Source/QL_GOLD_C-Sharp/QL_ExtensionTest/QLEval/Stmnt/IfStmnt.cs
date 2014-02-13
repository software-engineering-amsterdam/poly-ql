using QL_ExtensionTest.QLEval.Expr;
using QL_Grammar.QLAlgebra.Stmnt;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class IfStmnt : IfStmnt<IEvalExpr, IEvalStmnt>, IEvalStmnt
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
