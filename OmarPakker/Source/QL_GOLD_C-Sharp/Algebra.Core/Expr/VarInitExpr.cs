using System;
using Algebra.Core.Tree;

namespace Algebra.Core.Expr
{
    public abstract class VarInitExpr<E, T> : IExprNode
        where E : IExprNode
        where T : ITypeNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public string Name { get; private set; }
		public T Type { get; private set; }
        public E Value { get; private set; }

        public VarInitExpr(string name, T type, E value)
		{
            Name = name;
			Type = type;
            Value = value;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is VarInitExpr<E, T>))
			{
				return false;
			}

			VarInitExpr<E, T> other = (VarInitExpr<E, T>)obj;
			return Name.Equals(other.Name) && Value.Equals(other.Value);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode() + Value.GetHashCode();
		}
    }
}
