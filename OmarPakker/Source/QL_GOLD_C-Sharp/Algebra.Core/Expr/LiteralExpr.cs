
namespace Algebra.Core.Expr
{
    public class LiteralExpr<V>
    {
        public V Value { get; private set; }

        public LiteralExpr(V value)
        {
            Value = value;
        }
    }
}
