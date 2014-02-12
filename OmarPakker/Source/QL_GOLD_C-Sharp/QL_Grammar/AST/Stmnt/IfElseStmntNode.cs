using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public class IfElseStmntNode<E, S> : IfStmntNode<E, S>
        where E : IExprNode
        where S : IStmntNode
	{
        public S IfFalseBody { get; private set; }

        public IfElseStmntNode(E check, S ifTrue, S ifFalse)
            : base(check, ifTrue)
		{
            IfFalseBody = ifFalse;
		}
	}
}
