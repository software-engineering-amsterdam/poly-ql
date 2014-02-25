using Algebra.QL.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class NotEqualExpr : DoubleExpr<IPrintExpr>, IPrintExpr
	{
		public NotEqualExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " != " + Expr2.BuildDocument();
        }
	}
}
