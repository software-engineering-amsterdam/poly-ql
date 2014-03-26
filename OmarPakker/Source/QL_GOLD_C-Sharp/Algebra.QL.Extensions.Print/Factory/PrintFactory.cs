using System;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Print.Expr;
using Algebra.QL.Extensions.Print.Expr.Literals;
using Algebra.QL.Extensions.Print.Stmnt;
using Algebra.QL.Extensions.Print.Type;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Extensions.Print.Factory
{
    public class PrintFactory : QL.Print.Factory.PrintFactory, IStmntFactory<IPrintStmnt, IPrintExpr, IPrintType>
    {
        public PrintFactory()
        {

        }

        public IPrintType DateType()
        {
            return new DateType();
        }

        public IPrintExpr Date(DateTime date)
        {
            return new DateLiteral(date);
        }

        public IPrintExpr Modulo(IPrintExpr l, IPrintExpr r)
        {
            return new ModuloExpr(l, r);
        }

        public IPrintExpr Power(IPrintExpr l, IPrintExpr r)
        {
            return new PowerExpr(l, r);
        }

        public IPrintStmnt Forms(IPrintStmnt l, IPrintStmnt r)
        {
            return new CompStmnt(l, r);
        }

        public IPrintStmnt Goto()
        {
            return new GotoStmnt();
        }

        public IPrintStmnt Repeat(IPrintExpr e, IPrintStmnt s)
        {
            return new RepeatStmnt(e, s);
        }

        public IPrintExpr Sum(string s)
        {
            return new SumExpr(s);
        }

        public IPrintExpr Average(string s)
        {
            return new AvgExpr(s);
        }
    }
}
