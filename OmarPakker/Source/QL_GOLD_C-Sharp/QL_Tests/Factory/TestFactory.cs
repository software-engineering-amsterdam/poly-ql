using System;
using Algebra.QL.Extensions.Factory;
using QL_Tests.Expr;
using QL_Tests.Stmnt;
using QL_Tests.Type;

namespace QL_Tests.Factory
{
    public class TestFactory : IFactory<ITestStmnt, ITestExpr, ITestType>
    {
        public TestFactory()
        {

        }

        public ITestType DateType()
        {
            return new BaseType<DateTime>();
        }

        public ITestType StringType()
        {
            return new BaseType<string>();
        }

        public ITestType IntType()
        {
            return new BaseType<int>();
        }

        public ITestType RealType()
        {
            return new BaseType<double>();
        }

        public ITestType BoolType()
        {
            return new BaseType<bool>();
        }

        public ITestExpr Date(DateTime date)
        {
            return new LiteralExpr<DateTime>(date);
        }

        public ITestExpr String(string s)
        {
            return new LiteralExpr<string>(s);
        }

        public ITestExpr Int(int i)
        {
            return new LiteralExpr<int>(i);
        }

        public ITestExpr Real(double d)
        {
            return new LiteralExpr<double>(d);
        }

        public ITestExpr Bool(bool b)
        {
            return new LiteralExpr<bool>(b);
        }

        public ITestExpr Variable(string var)
        {
            return new VarExpr(var);
        }

        public ITestExpr Or(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr And(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Eq(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr NotEq(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr LessThen(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr GreaterThen(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr LessOrEqualTo(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr GreaterOrEqualTo(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Add(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Subtract(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Multiply(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Divide(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Modulo(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr Power(ITestExpr l, ITestExpr r)
        {
            return new BinaryExpr(l, r);
        }

        public ITestExpr NegateBool(ITestExpr e)
        {
            return new UnaryExpr(e);
        }

        public ITestExpr NegateNumeric(ITestExpr e)
        {
            return new UnaryExpr(e);
        }

        public ITestExpr VarDecl(string var, ITestType t)
        {
            return new VarInitExpr(var, t, new LiteralExpr<object>(0));
        }

        public ITestExpr VarAssign(string var, ITestType t, ITestExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public ITestExpr IfElse(ITestExpr toEval, ITestExpr ifTrue, ITestExpr ifFalse)
        {
            return new TernaryExpr(toEval, ifTrue, ifFalse);
        }

        public ITestExpr ExpressionOrder(ITestExpr e)
        {
            return e; //We can skip this
        }

        public ITestStmnt Forms(ITestStmnt l, ITestStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public ITestStmnt Statements(ITestStmnt l, ITestStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public ITestStmnt Form(string var, ITestStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public ITestStmnt Goto()
        {
            return new GotoStmnt();
        }

        public ITestStmnt Question(string s, ITestExpr e)
        {
            return new TextExprStmnt(s, e);
        }

        public ITestStmnt Label(string s, ITestExpr e)
        {
            return new TextExprStmnt(s, e);
        }

        public ITestStmnt If(ITestExpr toEval, ITestStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public ITestStmnt IfElse(ITestExpr toEval, ITestStmnt ifTrue, ITestStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }

        public ITestStmnt Repeat(ITestExpr e, ITestStmnt s)
        {
            return new RepeatStmnt(e, s);
        }

        public ITestExpr Sum(string s)
        {
            return new SumExpr(s);
        }

        public ITestExpr Average(string s)
        {
            return new AvgExpr(s);
        }

        public ITestStmnt Block(ITestStmnt s)
        {
            return s; //We can skip this
        }
    }
}
