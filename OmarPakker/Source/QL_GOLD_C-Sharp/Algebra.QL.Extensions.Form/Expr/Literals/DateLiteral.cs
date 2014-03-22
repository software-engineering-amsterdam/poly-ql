using System;
using Algebra.QL.Extensions.Form.Type;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, IFormExpr
    {
        public override IFormType Type { get { return new DateType(); } }

        public DateLiteral(DateTime date)
            : base(date)
        {

        }
    }
}
