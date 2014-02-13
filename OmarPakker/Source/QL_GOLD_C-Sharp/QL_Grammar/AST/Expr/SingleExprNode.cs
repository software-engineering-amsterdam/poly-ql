using System;

namespace QL_Grammar.AST.Expr
{
    public abstract class SingleExprNode<E> : IExprNode
        where E : IExprNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public E Expr1 { get; private set; }

        public SingleExprNode(E e1)
        {
            Expr1 = e1;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is SingleExprNode<E>))
			{
				return false;
			}

			return Expr1.Equals(((SingleExprNode<E>)obj).Expr1);
		}
    }
}
