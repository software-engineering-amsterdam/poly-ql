using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
    public class VarExpr : VarExprNode<IEvalExpr>, IEvalExpr
    {
        public VarExpr(string name, IType type, IEvalExpr value)
            : base(name, type, value)
		{

		}

		public IValue Eval()
		{
			return Value.Eval();
		}
    }
}
