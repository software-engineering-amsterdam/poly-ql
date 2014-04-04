using Algebra.QL.Core.Factory;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Expr.Literals;

namespace Algebra.QL.Eval.Factory
{
    public class EvalFactory<T> : IExprFactory<IEvalExpr, T>
    {
        public EvalFactory()
        {

        }

        public IEvalExpr String(string s)
        {
            return new LiteralExpr<string>(s);
        }

        public IEvalExpr Int(int i)
        {
            return new LiteralExpr<int>(i);
        }

        public IEvalExpr Real(double d)
        {
            return new LiteralExpr<double>(d);
        }

        public IEvalExpr Bool(bool b)
        {
            return new LiteralExpr<bool>(b);
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

        public IEvalExpr NegateBool(IEvalExpr e)
        {
            return new NegateBoolExpr(e);
        }

        public IEvalExpr NegateNumeric(IEvalExpr e)
        {
            return new NegateNumericExpr(e);
        }

        public IEvalExpr VarDecl(string var, T t)
        {
            return new VarInitExpr<T>(var, t, null); //TODO: Using this currently breaks evaulation
        }

        public IEvalExpr VarAssign(string var, T t, IEvalExpr e)
        {
            return new VarInitExpr<T>(var, t, e);
        }

        public IEvalExpr IfElse(IEvalExpr toEval, IEvalExpr ifTrue, IEvalExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public IEvalExpr ExpressionOrder(IEvalExpr e)
        {
            return e;
        }
    }
}
