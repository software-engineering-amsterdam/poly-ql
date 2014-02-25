using System;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Type;
using Algebra.QL.Extensions.Value;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.Core.Type;
using Algebra.Core.Value;
using Algebra.QL.Core.Type;
using Algebra.QL.Core.Value;

namespace Algebra.QL.Print.Factory
{
    public class QLPrintFactory : IQLExtensionsFactory<IPrintExpr, IPrintStmnt>
    {
        public QLPrintFactory()
        {

        }

		public IType DateType()
		{
			return new DateType();
		}

		//TODO: See if we can change this so you don't have to cover for types that stay the same
        //Probably need to seperate types into its own factory to be able to do this.
		#region Type duplication
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
		#endregion

        public IPrintExpr Date(DateTime date)
		{
			return Literal(new DateValue(date));
		}

        public IPrintExpr String(string s)
        {
            return Literal(new StringValue(s));
        }

        public IPrintExpr Int(int i)
        {
            return Literal(new IntValue(i));
        }

        public IPrintExpr Real(double d)
        {
            return Literal(new RealValue(d));
        }

        public IPrintExpr Bool(bool b)
        {
            return Literal(new BoolValue(b));
        }

        public IPrintExpr Literal(IValue value)
        {
            return new LiteralExpr(value);
        }

        public IPrintExpr Variable(string var)
        {
            return new VarExpr(var);
        }

        public IPrintExpr Or(IPrintExpr l, IPrintExpr r)
        {
            return new OrExpr(l, r);
        }

        public IPrintExpr And(IPrintExpr l, IPrintExpr r)
        {
            return new AndExpr(l, r);
        }

        public IPrintExpr Eq(IPrintExpr l, IPrintExpr r)
        {
            return new EqualsExpr(l, r);
        }

        public IPrintExpr NotEq(IPrintExpr l, IPrintExpr r)
        {
            return new NotEqualExpr(l, r);
        }

        public IPrintExpr LessThen(IPrintExpr l, IPrintExpr r)
        {
            return new LessThenExpr(l, r);
        }

        public IPrintExpr GreaterThen(IPrintExpr l, IPrintExpr r)
        {
            return new GreaterThenExpr(l, r);
        }

        public IPrintExpr LessOrEqualTo(IPrintExpr l, IPrintExpr r)
        {
            return new LessOrEqualToExpr(l, r);
        }

        public IPrintExpr GreaterOrEqualTo(IPrintExpr l, IPrintExpr r)
        {
            return new GreaterOrEqualToExpr(l, r);
        }

        public IPrintExpr Add(IPrintExpr l, IPrintExpr r)
        {
            return new AddExpr(l, r);
        }

        public IPrintExpr Subtract(IPrintExpr l, IPrintExpr r)
        {
            return new SubtractExpr(l, r);
        }

        public IPrintExpr Multiply(IPrintExpr l, IPrintExpr r)
        {
            return new MultiplyExpr(l, r);
        }

        public IPrintExpr Divide(IPrintExpr l, IPrintExpr r)
        {
            return new DivideExpr(l, r);
        }

        public IPrintExpr Negate(IType t, IPrintExpr e)
        {
            return new NegateExpr(t, e);
        }

        public IPrintExpr VarDecl(string var, IType t)
        {
            return VarAssign(var, t, Literal(t.DefaultValue));
        }

        public IPrintExpr VarAssign(string var, IType t, IPrintExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public IPrintExpr IfElse(IPrintExpr toEval, IPrintExpr ifTrue, IPrintExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public IPrintStmnt Form(string var, IPrintStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public IPrintStmnt Goto(string var)
        {
            return new GotoStmnt(var);
        }

        public IPrintStmnt Comp(IPrintStmnt l, IPrintStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public IPrintStmnt Question(string s, bool b, IPrintExpr e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public IPrintStmnt If(IPrintExpr toEval, IPrintStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public IPrintStmnt IfElse(IPrintExpr toEval, IPrintStmnt ifTrue, IPrintStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }

        //Extensions as well
        public IPrintExpr Modulo(IPrintExpr l, IPrintExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public IPrintExpr Power(IPrintExpr l, IPrintExpr r)
        {
            return new PowerExpr(l, r);
        }

        public IPrintStmnt Loop(IPrintExpr e, IPrintStmnt s)
        {
            return new LoopStmnt(e, s);
        }
	}
}
