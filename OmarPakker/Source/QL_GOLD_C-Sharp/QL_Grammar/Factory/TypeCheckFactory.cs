using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;
using QL_Grammar.TypeCheck.Expr;
using QL_Grammar.TypeCheck.Stmnt;

namespace QL_Grammar.Factory
{
    public class TypeCheckFactory : BaseFactory<ITypeCheckExpr, ITypeCheckStmnt>
    {
        public TypeCheckFactory()
            : base()
		{

		}

        public override ITypeCheckExpr Literal(IValue value)
        {
            return new LiteralExpr(value);
        }

		public override ITypeCheckExpr Or(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new OrExpr(l, r);
		}

		public override ITypeCheckExpr And(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new AndExpr(l, r);
		}

        public override ITypeCheckExpr Eq(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new EqualsExpr(l, r);
		}

        public override ITypeCheckExpr NotEq(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new NotEqualExpr(l, r);
		}

        public override ITypeCheckExpr LessThen(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new LessThenExpr(l, r);
		}

        public override ITypeCheckExpr GreaterThen(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new GreaterThenExpr(l, r);
		}

        public override ITypeCheckExpr LessOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new LessOrEqualToExpr(l, r);
		}

        public override ITypeCheckExpr GreaterOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new GreaterOrEqualToExpr(l, r);
		}

        public override ITypeCheckExpr Add(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new AddExpr(l, r);
		}

        public override ITypeCheckExpr Subtract(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new SubtractExpr(l, r);
		}

        public override ITypeCheckExpr Multiply(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new MultiplyExpr(l, r);
		}

        public override ITypeCheckExpr Divide(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new DivideExpr(l, r);
		}

        public override ITypeCheckExpr Negate(ITypeCheckExpr e)
		{
			return new NegateExpr(e);
		}

        public override ITypeCheckExpr VarDecl(string var, IType t)
        {
            if (Variables.ContainsKey(var))
            {
                if(Variables[var].ExprType.Equals(t))
                {
                    //TODO: Variable re-use warning
                }
                else
                {
                    //TODO: Variable re-definition error
                }
            }

            return base.VarDecl(var, t);
        }

        public override ITypeCheckExpr VarAssign(string var, IType t, ITypeCheckExpr e)
        {
            Variables[var] = new VarExpr(var, t, e);

            return Variables[var];
        }

        public override ITypeCheckExpr IfElse(ITypeCheckExpr toEval, ITypeCheckExpr ifTrue, ITypeCheckExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public override ITypeCheckStmnt Form(string var, ITypeCheckStmnt s)
        {
            Variables.Clear();
            Forms.Add(var, new FormStmnt(var, s));

            return Forms[var];
        }

        public override ITypeCheckStmnt Goto(string var)
        {
            return new GotoStmnt(var, Forms);
        }

        public override ITypeCheckStmnt Comp(ITypeCheckStmnt l, ITypeCheckStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public override ITypeCheckStmnt Question(string s, bool b, ITypeCheckExpr e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public override ITypeCheckStmnt If(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public override ITypeCheckStmnt IfElse(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }
    }
}
