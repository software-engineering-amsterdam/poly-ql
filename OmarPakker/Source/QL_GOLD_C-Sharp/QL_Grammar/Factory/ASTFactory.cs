using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Factory
{
    public class ASTFactory : BaseFactory<IExprNode, IStmntNode>
    {
        public ASTFactory()
            : base()
        {

        }

        public override IExprNode Literal(IValue value)
        {
            return new LiteralExprNode(value);
        }

		public override IExprNode Variable(string var)
		{
			return new VarExprNode(var);
		}

        public override IExprNode Or(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode And(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Eq(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode NotEq(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode LessThen(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode GreaterThen(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode LessOrEqualTo(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode GreaterOrEqualTo(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Add(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Subtract(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Multiply(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Divide(IExprNode l, IExprNode r)
        {
            return new DoubleExprNode<IExprNode>(l, r);
        }

        public override IExprNode Negate(IExprNode e)
        {
            return new SingleExprNode<IExprNode>(e);
        }

        public override IExprNode VarAssign(string var, IType t, IExprNode e)
        {
			return new VarInitExprNode<IExprNode>(var, t, e);
        }

        public override IExprNode IfElse(IExprNode toEval, IExprNode ifTrue, IExprNode ifFalse)
        {
            return new TripleExprNode<IExprNode>(toEval, ifTrue, ifFalse);
        }

        public override IStmntNode Form(string var, IStmntNode s)
        {
            return new FormStmntNode<IStmntNode>(var, s);
        }

        public override IStmntNode Goto(string var)
        {
            return new GotoStmntNode(var);
        }

        public override IStmntNode Comp(IStmntNode l, IStmntNode r)
        {
            return new CompStmntNode<IStmntNode>(l, r);
        }

        public override IStmntNode Question(string s, bool b, IExprNode e)
        {
            return new QuestionStmntNode<IExprNode>(s, b, e);
        }

        public override IStmntNode If(IExprNode toEval, IStmntNode ifTrue)
        {
            return new IfStmntNode<IExprNode, IStmntNode>(toEval, ifTrue);
        }

        public override IStmntNode IfElse(IExprNode toEval, IStmntNode ifTrue, IStmntNode ifFalse)
        {
            return new IfElseStmntNode<IExprNode, IStmntNode>(toEval, ifTrue, ifFalse);
        }
    }
}
