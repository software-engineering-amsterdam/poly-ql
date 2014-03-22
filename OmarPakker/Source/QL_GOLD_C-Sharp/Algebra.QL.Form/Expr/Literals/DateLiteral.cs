using System;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
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
