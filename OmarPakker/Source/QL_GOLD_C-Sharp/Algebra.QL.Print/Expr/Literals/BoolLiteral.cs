using System.Collections.Generic;
using System.Windows.Documents;

namespace Algebra.QL.Print.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, IPrintExpr
    {
        public BoolLiteral(bool value)
            : base(value)
        {

        }

        public override IEnumerable<Inline> BuildDocument()
        {
            return new[] { new Run(ToString()) { Foreground = StyleSettings.KeyWordColor } };
        }

        public override string ToString()
        {
            return base.ToString().ToLowerInvariant();
        }
    }
}
