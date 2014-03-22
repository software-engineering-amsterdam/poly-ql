using Algebra.QL.Core.Factory;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Factory
{
    public class PrintFactory : IStmntFactory<IPrintStmnt, IPrintExpr, IPrintType>
    {
        public PrintFactory()
        {

        }

        public IPrintType StringType()
        {
            return new StringType();
        }

        public IPrintType IntType()
        {
            return new IntType();
        }

        public IPrintType RealType()
        {
            return new RealType();
        }

        public IPrintType BoolType()
        {
            return new BoolType();
        }

        public IPrintExpr String(string s)
        {
            return new StringLiteral(s);
        }

        public IPrintExpr Int(int i)
        {
            return new IntLiteral(i);
        }

        public IPrintExpr Real(double d)
        {
            return new RealLiteral(d);
        }

        public IPrintExpr Bool(bool b)
        {
            return new BoolLiteral(b);
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

        public IPrintExpr NegateBool(IPrintExpr e)
        {
            return new NegateBoolExpr(e);
        }

        public IPrintExpr NegateNumeric(IPrintExpr e)
        {
            return new NegateNumericExpr(e);
        }

        public IPrintExpr VarDecl(string var, IPrintType t)
        {
            return VarAssign(var, t, t.DefaultValue);
        }

        public IPrintExpr VarAssign(string var, IPrintType t, IPrintExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public IPrintExpr IfElse(IPrintExpr toEval, IPrintExpr ifTrue, IPrintExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public IPrintStmnt Forms(IPrintStmnt l, IPrintStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public IPrintStmnt Statements(IPrintStmnt l, IPrintStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public IPrintStmnt Form(string var, IPrintStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public IPrintStmnt Question(string s, IPrintExpr e)
        {
            return new QuestionStmnt(s, e);
        }

        public IPrintStmnt Label(string s, IPrintExpr e)
        {
            return new LabelStmnt(s, e);
        }

        public IPrintStmnt If(IPrintExpr toEval, IPrintStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public IPrintStmnt IfElse(IPrintExpr toEval, IPrintStmnt ifTrue, IPrintStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }
    }
}
