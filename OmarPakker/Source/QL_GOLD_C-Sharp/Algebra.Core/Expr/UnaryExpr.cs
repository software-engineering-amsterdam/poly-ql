using System;
using Algebra.Core.Tree;

namespace Algebra.Core.Expr
{
    public abstract class UnaryExpr<E> : IExprNode
        where E : IExprNode
    {
        public Tuple<int, int> SourcePosition { get; set; }
        public E Expr1 { get; private set; }

        public UnaryExpr(E e1)
        {
            Expr1 = e1;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is UnaryExpr<E>))
			{
				return false;
			}

			return Expr1.Equals(((UnaryExpr<E>)obj).Expr1);
		}

		public override int GetHashCode()
		{
			return Expr1.GetHashCode();
		}
    }
}
