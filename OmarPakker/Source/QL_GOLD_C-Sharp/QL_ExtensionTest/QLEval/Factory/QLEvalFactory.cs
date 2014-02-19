using QL_ExtensionTest.QLAlgebraExtensions.Factory;
using QL_ExtensionTest.QLEval.Expr;
using QL_ExtensionTest.QLEval.Stmnt;
using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Value;

namespace QL_ExtensionTest.QLEval.Factory
{
    public class QLEvalFactory : IQLExtensionsFactory<IEvalExpr, IEvalStmnt>
    {
        public QLEvalFactory()
        {

        }

        public IEvalExpr String(string s)
        {
            return Literal(new StringValue(s));
        }

        public IEvalExpr Int(int i)
        {
            return Literal(new IntValue(i));
        }

        public IEvalExpr Real(double d)
        {
            return Literal(new RealValue(d));
        }

        public IEvalExpr Bool(bool b)
        {
            return Literal(new BoolValue(b));
        }

        public IEvalExpr Literal(IValue value)
        {
            return new LiteralExpr(value);
        }

        public IEvalExpr Variable(string var)
        {
            return new VarExpr(var);
        }

        public IEvalExpr Or(IEvalExpr l, IEvalExpr r)
        {
            return new OrExpr(l, r);
        }

        public IEvalExpr And(IEvalExpr l, IEvalExpr r)
        {
            return new AndExpr(l, r);
        }

        public IEvalExpr Eq(IEvalExpr l, IEvalExpr r)
        {
            return new EqualsExpr(l, r);
        }

        public IEvalExpr NotEq(IEvalExpr l, IEvalExpr r)
        {
            return new NotEqualExpr(l, r);
        }

        public IEvalExpr LessThen(IEvalExpr l, IEvalExpr r)
        {
            return new LessThenExpr(l, r);
        }

        public IEvalExpr GreaterThen(IEvalExpr l, IEvalExpr r)
        {
            return new GreaterThenExpr(l, r);
        }

        public IEvalExpr LessOrEqualTo(IEvalExpr l, IEvalExpr r)
        {
            return new LessOrEqualToExpr(l, r);
        }

        public IEvalExpr GreaterOrEqualTo(IEvalExpr l, IEvalExpr r)
        {
            return new GreaterOrEqualToExpr(l, r);
        }

        public IEvalExpr Add(IEvalExpr l, IEvalExpr r)
        {
            return new AddExpr(l, r);
        }

        public IEvalExpr Subtract(IEvalExpr l, IEvalExpr r)
        {
            return new SubtractExpr(l, r);
        }

        public IEvalExpr Multiply(IEvalExpr l, IEvalExpr r)
        {
            return new MultiplyExpr(l, r);
        }

        public IEvalExpr Divide(IEvalExpr l, IEvalExpr r)
        {
            return new DivideExpr(l, r);
        }

        public IEvalExpr Negate(IEvalExpr e)
        {
            return new NegateExpr(e);
        }

        public IEvalExpr VarDecl(string var, IType t)
        {
            return VarAssign(var, t, Literal(t.DefaultValue));
        }

        public IEvalExpr VarAssign(string var, IType t, IEvalExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public IEvalExpr IfElse(IEvalExpr toEval, IEvalExpr ifTrue, IEvalExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public IEvalStmnt Form(string var, IEvalStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public IEvalStmnt Goto(string var)
        {
            return new GotoStmnt(var);
        }

        public IEvalStmnt Comp(IEvalStmnt l, IEvalStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public IEvalStmnt Question(string s, bool b, IEvalExpr e)
        {
            return new QuestionStmnt(s, b, e);
        }

        public IEvalStmnt If(IEvalExpr toEval, IEvalStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public IEvalStmnt IfElse(IEvalExpr toEval, IEvalStmnt ifTrue, IEvalStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }

        //Extensions as well
        public IEvalExpr Modulo(IEvalExpr l, IEvalExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public IEvalExpr Power(IEvalExpr l, IEvalExpr r)
        {
            return new PowerExpr(l, r);
        }

        public IEvalStmnt Loop(IEvalExpr e, IEvalStmnt s)
        {
            return new LoopStmnt(e, s);
        }
    }
}
