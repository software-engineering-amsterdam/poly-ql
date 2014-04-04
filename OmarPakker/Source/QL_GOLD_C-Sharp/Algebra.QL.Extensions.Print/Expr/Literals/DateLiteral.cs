using System;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Extensions.Print.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, IPrintExpr
    {
        public DateLiteral(DateTime date)
            : base(date)
        {

        }

        public override string ToString()
        {
            return Value.ToString("yyyy-MM-dd HH:mm:ss zzz");
        }
    }
}
