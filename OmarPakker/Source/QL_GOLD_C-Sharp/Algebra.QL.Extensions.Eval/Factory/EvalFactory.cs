using System;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Expr.Literals;
using Algebra.QL.Extensions.Eval.Expr;
using Algebra.QL.Extensions.Factory;

namespace Algebra.QL.Extensions.Eval.Factory
{
    public class EvalFactory<T> : QL.Eval.Factory.EvalFactory<T>, IExprFactory<IEvalExpr, T>
    {
        public EvalFactory()
        {

        }

        public IEvalExpr Date(DateTime date)
        {
            return new LiteralExpr<DateTime>(date);
        }

        public IEvalExpr Modulo(IEvalExpr l, IEvalExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public IEvalExpr Power(IEvalExpr l, IEvalExpr r)
        {
            return new PowerExpr(l, r);
        }

        public IEvalExpr Sum(string s)
        {
            return new SumExpr(s);
        }

        public IEvalExpr Average(string s)
        {
            return new AvgExpr(s);
        }
    }
}
