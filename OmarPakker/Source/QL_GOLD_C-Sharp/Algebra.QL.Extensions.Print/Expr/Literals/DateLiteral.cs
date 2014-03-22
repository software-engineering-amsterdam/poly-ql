using System;
using Algebra.QL.Extensions.Print.Type;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Extensions.Print.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, IPrintExpr
    {
        public override IPrintType Type { get { return new DateType(); } }

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
