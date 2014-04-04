using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Extensions.Print.Expr
{
    public class PowerExpr : BinaryExpr<IPrintExpr>, IPrintExpr
    {
        public PowerExpr(IPrintExpr l, IPrintExpr r)
            : base(l, r)
        {

        }

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>();
            inlines.AddRange(Expr1.BuildDocument());
            inlines.Add(new Run(" ^ "));
            inlines.AddRange(Expr2.BuildDocument());
            return inlines;
        }
    }
}
