using System;
using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Expr
{
    public abstract class VarInitExprNode<E> : IExprNode
        where E : IExprNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string Name { get; private set; }
        public IType Type { get; private set; }
        public E Value { get; private set; }

        public VarInitExprNode(string name, IType type, E value)
		{
            Name = name;
            Type = type;
            Value = value;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is VarInitExprNode<E>))
			{
				return false;
			}

			VarInitExprNode<E> other = (VarInitExprNode<E>)obj;
			return Name.Equals(other.Name) && Type.Equals(other.Type) && Value.Equals(other.Value);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode() + Type.GetHashCode() + Value.GetHashCode();
		}
    }
}
