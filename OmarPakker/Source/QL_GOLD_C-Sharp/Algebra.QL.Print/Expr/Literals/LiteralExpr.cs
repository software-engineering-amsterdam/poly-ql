using System.Collections.Generic;
using System.Windows.Documents;

namespace Algebra.QL.Print.Expr.Literals
{
    public abstract class LiteralExpr<V> : Algebra.Core.Expr.LiteralExpr<V>, IPrintExpr
    {
        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public virtual IEnumerable<Inline> BuildDocument()
        {
            return new[] { new Run(Value.ToString()) };
        }

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
