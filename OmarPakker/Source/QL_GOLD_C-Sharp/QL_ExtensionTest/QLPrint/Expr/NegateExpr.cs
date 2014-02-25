using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Type;

namespace QL_ExtensionTest.QLPrint.Expr
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
