using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class GreaterOrEqualToExpr : BinaryExpr<IPrintExpr>, IPrintExpr
	{
		public GreaterOrEqualToExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
		{

		}

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>();
            inlines.AddRange(Expr1.BuildDocument());
            inlines.Add(new Run(" >= "));
            inlines.AddRange(Expr2.BuildDocument());
            return inlines;
        }
	}
}
