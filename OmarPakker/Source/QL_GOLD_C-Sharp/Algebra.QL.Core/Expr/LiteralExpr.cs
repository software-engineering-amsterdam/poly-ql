using System;
using Algebra.Core.Tree;

namespace Algebra.QL.Core.Expr
{
    public abstract class LiteralExpr<T, V> : IExprNode
        where T : ITypeNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public abstract T Type { get; }
        public V Value { get; private set; }

        public LiteralExpr(V value)
        {
            Value = value;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is LiteralExpr<T, V>))
			{
				return false;
			}

			return Value.Equals(((LiteralExpr<T, V>)obj).Value);
		}

		public override int GetHashCode()
		{
			return Value.GetHashCode();
		}

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
