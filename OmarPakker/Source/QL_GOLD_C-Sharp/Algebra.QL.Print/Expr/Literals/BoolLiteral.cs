using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
{
    public class BoolLiteral : LiteralExpr<bool>, IPrintExpr
    {
        public override IPrintType Type { get { return new BoolType(); } }

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
