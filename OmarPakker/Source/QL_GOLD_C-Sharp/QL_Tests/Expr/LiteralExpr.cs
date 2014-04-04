
namespace QL_Tests.Expr
{
    public class LiteralExpr<V> : ITestExpr
    {
        public V Value { get; private set; }

        public LiteralExpr(V value)
        {
            Value = value;
        }

        public override bool Equals(object obj)
        {
            if (!(obj is LiteralExpr<V>))
            {
                return false;
            }

            return Value.Equals(((LiteralExpr<V>)obj).Value);
        }

        public override int GetHashCode()
        {
            return Value.GetHashCode();
        }
    }
}
