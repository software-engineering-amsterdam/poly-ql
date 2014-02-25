using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public class SubtractExpr : DoubleExpr<IPrintExpr>, IPrintExpr
	{
		public SubtractExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " - " + Expr2.BuildDocument();
        }
	}
}
