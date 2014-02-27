using System;
using Algebra.QL.Extensions.TypeCheck.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, ITypeCheckExpr
    {
        public override ITypeCheckType Type { get { return new DateType(); } }

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
