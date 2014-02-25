using Algebra.Core.Type;
using Algebra.QL.Core.Expr;
using Algebra.QL.Core.Type;

namespace Algebra.QL.Print.Expr
{
	public class NegateExpr : SingleExpr<IPrintExpr>, IPrintExpr
	{
        private readonly IType NegationType;

		public NegateExpr(IType t, IPrintExpr e)
            : base(e)
		{
            NegationType = t;
		}

        public string BuildDocument()
        {
            return (NegationType.CompatibleWith(new BoolType()) ? "!" : "-") + Expr1.BuildDocument();
        }
	}
}
