using QL_Grammar.Value;

namespace QL_Grammar.Expr
{
	public class EqualsExpr : IExpr
	{
		private readonly IExpr l;
		private readonly IExpr r;

		public EqualsExpr(IExpr a, IExpr b)
		{
			l = a;
			r = b;
		}

		public IValue Eval()
		{
			return new BoolValue(l.Eval().Value.Equals(r.Eval().Value));
		}
	}
}
