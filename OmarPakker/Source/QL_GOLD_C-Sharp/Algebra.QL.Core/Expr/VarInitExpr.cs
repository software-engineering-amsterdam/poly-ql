using System;
using Algebra.Core.Type;

namespace Algebra.QL.Core.Expr
{
    public abstract class VarInitExpr<E>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string Name { get; private set; }
		public IType Type { get; private set; }
        public E Value { get; private set; }

        public VarInitExpr(string name, IType type, E value)
		{
            Name = name;
			Type = type;
            Value = value;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is VarInitExpr<E>))
			{
				return false;
			}

			VarInitExpr<E> other = (VarInitExpr<E>)obj;
			return Name.Equals(other.Name) && Value.Equals(other.Value);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode() + Value.GetHashCode();
		}
    }
}
