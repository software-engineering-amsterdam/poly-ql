using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.Eval.Expr;
using QL_Grammar.Eval.Stmnt;

namespace QL_Grammar.Factory
{
    public class EvalFactory : BaseFactory<IEvalExpr, IEvalStmnt>
	{
        private Dictionary<string, IEvalStmnt> forms;

		public EvalFactory()
            : base()
		{
            forms = new Dictionary<string, IEvalStmnt>();
		}

        public override IEvalExpr Literal(IValue value)
        {
            return new LiteralExpr(value);
        }

		public override IEvalExpr Or(IEvalExpr l, IEvalExpr r)
		{
			return new OrExpr(l, r);
		}

		public override IEvalExpr And(IEvalExpr l, IEvalExpr r)
		{
			return new AndExpr(l, r);
		}

        public override IEvalExpr Eq(IEvalExpr l, IEvalExpr r)
		{
			return new EqualsExpr(l, r);
		}

        public override IEvalExpr NotEq(IEvalExpr l, IEvalExpr r)
		{
			return new NotEqualExpr(l, r);
		}

        public override IEvalExpr LessThen(IEvalExpr l, IEvalExpr r)
		{
			return new LessThenExpr(l, r);
		}

        public override IEvalExpr GreaterThen(IEvalExpr l, IEvalExpr r)
		{
			return new GreaterThenExpr(l, r);
		}

        public override IEvalExpr LessOrEqualTo(IEvalExpr l, IEvalExpr r)
		{
			return new LessOrEqualToExpr(l, r);
		}

        public override IEvalExpr GreaterOrEqualTo(IEvalExpr l, IEvalExpr r)
		{
			return new GreaterOrEqualToExpr(l, r);
		}

        public override IEvalExpr Add(IEvalExpr l, IEvalExpr r)
		{
			return new AddExpr(l, r);
		}

        public override IEvalExpr Subtract(IEvalExpr l, IEvalExpr r)
		{
			return new SubtractExpr(l, r);
		}

        public override IEvalExpr Multiply(IEvalExpr l, IEvalExpr r)
		{
			return new MultiplyExpr(l, r);
		}

        public override IEvalExpr Divide(IEvalExpr l, IEvalExpr r)
		{
			return new DivideExpr(l, r);
		}

        public override IEvalExpr Negate(IEvalExpr e)
		{
			return new NegateExpr(e);
		}

        public override IEvalExpr VarAssign(string var, IType t, IEvalExpr e)
        {
            Variables[var] = new VarExpr(var, t, e);

            return Variables[var];
        }

        public override IEvalStmnt Form(string var, IEvalStmnt s)
        {
            Variables.Clear();
            forms.Add(var, new FormStmnt(var, s));

            return forms[var];
        }

        public override IEvalExpr IfElse(IEvalExpr toEval, IEvalExpr ifTrue, IEvalExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public override IEvalStmnt Goto(string var)
        {
            return new GotoStmnt(var, new ReadOnlyDictionary<string, IEvalStmnt>(forms));
        }

        public override IEvalStmnt Comp(IEvalStmnt l, IEvalStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public override IEvalStmnt Question(string s, bool b, IEvalExpr e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public override IEvalStmnt If(IEvalExpr toEval, IEvalStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public override IEvalStmnt IfElse(IEvalExpr toEval, IEvalStmnt ifTrue, IEvalStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }
	}
}
