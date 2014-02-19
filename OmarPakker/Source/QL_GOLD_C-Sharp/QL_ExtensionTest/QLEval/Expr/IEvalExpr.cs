using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
    public interface IEvalExpr : IEval
	{
		IValue Eval();
	}
}
