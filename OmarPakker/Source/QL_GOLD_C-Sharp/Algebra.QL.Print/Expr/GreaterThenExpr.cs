using Algebra.QL.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class GreaterThenExpr : BinaryExpr<IPrintExpr>, IPrintExpr
	{
		public GreaterThenExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public string BuildDocument()
        {
            return Expr1.BuildDocument() + " > " + Expr2.BuildDocument();
        }
	}
}
