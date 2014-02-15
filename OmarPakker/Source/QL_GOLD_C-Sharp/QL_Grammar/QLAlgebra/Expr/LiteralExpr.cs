using System;
using QL_Grammar.Algebra.Value;

namespace QL_Grammar.QLAlgebra.Expr
{
    public class LiteralExpr
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public IValue Value { get; private set; }

        public LiteralExpr(IValue value)
        {
            Value = value;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is LiteralExpr))
			{
				return false;
			}

			return Value.Equals(((LiteralExpr)obj).Value);
		}

		public override int GetHashCode()
		{
			return Value.GetHashCode();
		}
    }
}
