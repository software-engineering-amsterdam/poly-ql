using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public class LessOrEqualToExpr : DoubleExpr<IPrintExpr>, IPrintExpr
	{
		public LessOrEqualToExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " <= " + Expr2.BuildDocument();
        }
	}
}
