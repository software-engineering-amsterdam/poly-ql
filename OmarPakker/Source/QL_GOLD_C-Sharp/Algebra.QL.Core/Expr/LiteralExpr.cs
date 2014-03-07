
namespace Algebra.QL.Core.Expr
{
    public abstract class LiteralExpr<T, V>
    {
        public abstract T Type { get; }
        public V Value { get; protected set; }

        public LiteralExpr(V value)
        {
            Value = value;
        }
    }
}
