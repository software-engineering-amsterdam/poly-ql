using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.QL.Expr;
using QL_Grammar.QL.Stmnt;

namespace QL_Grammar.Factory
{
    public class QLFactory : BaseFactory<IExprNode, IStmntNode>
    {
        public QLFactory()
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
			return new OrExpr(l, r);
		}

		public override IExprNode And(IExprNode l, IExprNode r)
		{
			return new AndExpr(l, r);
		}

        public override IExprNode Eq(IExprNode l, IExprNode r)
		{
			return new EqualsExpr(l, r);
		}

        public override IExprNode NotEq(IExprNode l, IExprNode r)
		{
			return new NotEqualExpr(l, r);
		}

        public override IExprNode LessThen(IExprNode l, IExprNode r)
		{
			return new LessThenExpr(l, r);
		}

        public override IExprNode GreaterThen(IExprNode l, IExprNode r)
		{
			return new GreaterThenExpr(l, r);
		}

        public override IExprNode LessOrEqualTo(IExprNode l, IExprNode r)
		{
			return new LessOrEqualToExpr(l, r);
		}

        public override IExprNode GreaterOrEqualTo(IExprNode l, IExprNode r)
		{
			return new GreaterOrEqualToExpr(l, r);
		}

        public override IExprNode Add(IExprNode l, IExprNode r)
		{
			return new AddExpr(l, r);
		}

        public override IExprNode Subtract(IExprNode l, IExprNode r)
		{
			return new SubtractExpr(l, r);
		}

        public override IExprNode Multiply(IExprNode l, IExprNode r)
		{
			return new MultiplyExpr(l, r);
		}

        public override IExprNode Divide(IExprNode l, IExprNode r)
		{
			return new DivideExpr(l, r);
		}

        public override IExprNode Negate(IExprNode e)
		{
			return new NegateExpr(e);
		}

        public override IExprNode VarAssign(string var, IType t, IExprNode e)
        {
            return new VarInitExpr(var, t, e);
        }

        public override IExprNode IfElse(IExprNode toEval, IExprNode ifTrue, IExprNode ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public override IStmntNode Form(string var, IStmntNode s)
        {
            return new FormStmnt(var, s);
        }

        public override IStmntNode Goto(string var)
        {
            return new GotoStmnt(var);
        }

        public override IStmntNode Comp(IStmntNode l, IStmntNode r)
        {
            return new CompStmnt(l, r);
        }

        public override IStmntNode Question(string s, bool b, IExprNode e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public override IStmntNode If(IExprNode toEval, IStmntNode ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public override IStmntNode IfElse(IExprNode toEval, IStmntNode ifTrue, IStmntNode ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }
    }
}
