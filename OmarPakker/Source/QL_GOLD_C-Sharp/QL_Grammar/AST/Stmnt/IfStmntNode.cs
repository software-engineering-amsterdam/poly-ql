using QL_Grammar.AST.Expr;

namespace QL_Grammar.AST.Stmnt
{
    public class IfStmntNode<E, S> : IStmntNode
        where E : IExprNode
        where S : IStmntNode
    {
        public E CheckExpression { get; private set; }
        public S IfTrueBody { get; private set; }

        public IfStmntNode(E check, S ifTrue)
		{
			CheckExpression = check;
            IfTrueBody = ifTrue;
		}
    }
}
