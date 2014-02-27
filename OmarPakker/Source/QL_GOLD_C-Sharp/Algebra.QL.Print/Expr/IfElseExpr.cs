using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;

namespace Algebra.QL.Print.Expr
{
    public class IfElseExpr : TernaryExpr<IPrintExpr>, IPrintExpr
    {
        public IfElseExpr(IPrintExpr a, IPrintExpr b, IPrintExpr c)
            : base(a, b, c)
        {

        }

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>();
            inlines.AddRange(Expr1.BuildDocument());
            inlines.Add(new Run(" ? "));
            inlines.AddRange(Expr2.BuildDocument());
            inlines.Add(new Run(" : "));
            inlines.AddRange(Expr3.BuildDocument());
            return inlines;
        }
    }
}
