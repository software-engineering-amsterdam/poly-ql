using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public interface IExpr
	{
		IValue Eval();
	}
}
