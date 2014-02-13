using System;
using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Expr
{
    public class LiteralExprNode : IExprNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public IValue Value { get; private set; }

        public LiteralExprNode(IValue value)
        {
            Value = value;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is LiteralExprNode))
			{
				return false;
			}

			return Value.Equals(((LiteralExprNode)obj).Value);
		}

		public override int GetHashCode()
		{
			return Value.GetHashCode();
		}
    }
}
