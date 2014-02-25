using Algebra.QL.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class GreaterOrEqualToExpr : DoubleExpr<IPrintExpr>, IPrintExpr
	{
		public GreaterOrEqualToExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " >= " + Expr2.BuildDocument();
        }
	}
}
