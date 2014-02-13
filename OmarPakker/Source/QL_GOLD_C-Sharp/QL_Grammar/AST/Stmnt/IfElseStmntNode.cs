using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public abstract class IfElseStmntNode<E, S> : IfStmntNode<E, S>
        where E : IExprNode
        where S : IStmntNode
	{
        public S IfFalseBody { get; private set; }

        public IfElseStmntNode(E check, S ifTrue, S ifFalse)
            : base(check, ifTrue)
		{
            IfFalseBody = ifFalse;
		}

		public override bool Equals(object obj)
		{
			if (!base.Equals(obj) || !(obj is IfElseStmntNode<E, S>))
			{
				return false;
			}

			return IfFalseBody.Equals(((IfElseStmntNode<E, S>)obj).IfFalseBody);
		}
	}
}
