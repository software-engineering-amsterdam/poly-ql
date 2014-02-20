using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Factory;
using QL_Grammar.QLAlgebra.Type;
using QL_Grammar.QLAlgebra.Value;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_Grammar.QLTypeCheck.Factory
{
	public class QLTypeCheckFactory : IQLFactory<ITypeCheckExpr, ITypeCheckStmnt>
    {
        public QLTypeCheckFactory()
            : base()
        {

        }

		public IType StringType()
		{
			return new StringType();
		}

		public IType IntType()
		{
			return new IntType();
		}

		public IType RealType()
		{
			return new RealType();
		}

		public IType BoolType()
		{
			return new BoolType();
		}

		public ITypeCheckExpr String(string s)
		{
			return Literal(new StringValue(s));
		}

		public ITypeCheckExpr Int(int i)
		{
			return Literal(new IntValue(i));
		}

		public ITypeCheckExpr Real(double d)
		{
			return Literal(new RealValue(d));
		}

		public ITypeCheckExpr Bool(bool b)
		{
			return Literal(new BoolValue(b));
		}

        public ITypeCheckExpr Literal(IValue value)
        {
            return new LiteralExpr(value);
        }

		public ITypeCheckExpr Variable(string var)
		{
			return new VarExpr(var);
		}

		public ITypeCheckExpr Or(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new OrExpr(l, r);
		}

		public ITypeCheckExpr And(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new AndExpr(l, r);
		}

        public ITypeCheckExpr Eq(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new EqualsExpr(l, r);
		}

        public ITypeCheckExpr NotEq(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new NotEqualExpr(l, r);
		}

        public ITypeCheckExpr LessThen(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new LessThenExpr(l, r);
		}

        public ITypeCheckExpr GreaterThen(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new GreaterThenExpr(l, r);
		}

        public ITypeCheckExpr LessOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new LessOrEqualToExpr(l, r);
		}

        public ITypeCheckExpr GreaterOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new GreaterOrEqualToExpr(l, r);
		}

        public ITypeCheckExpr Add(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new AddExpr(l, r);
		}

        public ITypeCheckExpr Subtract(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new SubtractExpr(l, r);
		}

        public ITypeCheckExpr Multiply(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new MultiplyExpr(l, r);
		}

        public ITypeCheckExpr Divide(ITypeCheckExpr l, ITypeCheckExpr r)
		{
			return new DivideExpr(l, r);
		}

        public ITypeCheckExpr Negate(ITypeCheckExpr e)
		{
			return new NegateExpr(e);
		}

		public ITypeCheckExpr VarDecl(string var, IType t)
		{
			return VarAssign(var, t, Literal(t.DefaultValue));
		}

        public ITypeCheckExpr VarAssign(string var, IType t, ITypeCheckExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public ITypeCheckExpr IfElse(ITypeCheckExpr toEval, ITypeCheckExpr ifTrue, ITypeCheckExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public ITypeCheckStmnt Form(string var, ITypeCheckStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public ITypeCheckStmnt Goto(string var)
        {
            return new GotoStmnt(var);
        }

        public ITypeCheckStmnt Comp(ITypeCheckStmnt l, ITypeCheckStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public ITypeCheckStmnt Question(string s, bool b, ITypeCheckExpr e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public ITypeCheckStmnt If(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public ITypeCheckStmnt IfElse(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }
	}
}
