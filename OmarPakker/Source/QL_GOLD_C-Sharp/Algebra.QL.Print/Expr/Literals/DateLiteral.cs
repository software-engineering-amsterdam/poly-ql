using System;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr.Literals
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
