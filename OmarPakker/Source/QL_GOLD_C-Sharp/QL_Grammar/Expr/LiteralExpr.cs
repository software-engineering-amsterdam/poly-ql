using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class LiteralExpr : IExpr
	{
		private readonly IValue v;

		public LiteralExpr(IValue value)
		{
			v = value;
		}

		public IValue Eval()
		{
			return v;
		}
	}
}
