using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.QL.Core.Expr;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<IPrintType, V>, IPrintExpr
    {
        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public virtual IEnumerable<Inline> BuildDocument()
        {
            return new[] { new Run(Value.ToString()) };
        }
    }
}
