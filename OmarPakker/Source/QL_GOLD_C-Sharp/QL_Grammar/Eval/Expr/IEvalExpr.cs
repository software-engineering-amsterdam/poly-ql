using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Eval.Expr
{
	public interface IEvalExpr : IExprNode
	{
		IValue Eval();
	}
}
