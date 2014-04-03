using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class OrderExpr : UnaryExpr<IPrintExpr>, IPrintExpr
    {
        public OrderExpr(IPrintExpr e)
            : base(e)
        {

        }

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>();
            inlines.Add(new Run("("));
            inlines.AddRange(Expr1.BuildDocument());
            inlines.Add(new Run(")"));
            return inlines;
        }
    }
}
