using Algebra.QL.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class OrExpr : DoubleExpr<IPrintExpr>, IPrintExpr
	{
		public OrExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " || " + Expr2.BuildDocument();
        }
	}
}
