using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class NegateNumericExpr : UnaryExpr<IPrintExpr>, IPrintExpr
    {
        public NegateNumericExpr(IPrintExpr e)
            : base(e)
        {

        }

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>
            {
                new Run("-")
            };
            inlines.AddRange(Expr1.BuildDocument());
            return inlines;
        }
    }
}
