using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.QL.Print;
using Algebra.QL.Print.Expr;

namespace Algebra.QL.Extensions.Print.Expr
{
    public class AvgExpr : IPrintExpr
    {
        private readonly string VarName;

        public AvgExpr(string s)
        {
            VarName = s;
        }

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>();
            inlines.Add(new Run("avg") { Foreground = StyleSettings.KeyWordColor });
            inlines.Add(new Run("("));
            inlines.Add(new Run(VarName));
            inlines.Add(new Run(")"));
            return inlines;
        }
    }
}
