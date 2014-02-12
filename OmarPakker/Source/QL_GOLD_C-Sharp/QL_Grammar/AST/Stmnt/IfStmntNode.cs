using System;
using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public class IfStmntNode<E, S> : IStmntNode
        where E : IExprNode
        where S : IStmntNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public E CheckExpression { get; private set; }
        public S IfTrueBody { get; private set; }

        public IfStmntNode(E check, S ifTrue)
		{
			CheckExpression = check;
            IfTrueBody = ifTrue;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IfStmntNode<E, S>))
			{
				return false;
			}

			IfStmntNode<E, S> other = (IfStmntNode<E, S>)obj;
			return CheckExpression.Equals(other.CheckExpression) && IfTrueBody.Equals(other.IfTrueBody);
		}
    }
}
