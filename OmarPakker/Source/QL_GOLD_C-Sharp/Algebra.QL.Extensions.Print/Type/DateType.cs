using System;
using Algebra.QL.Extensions.Print.Expr.Literals;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Extensions.Print.Type
{
    public class DateType : BaseType
    {
        public override IPrintExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow.Date); } }

        public DateType()
        {

        }

        public override string ToString()
        {
            return "date";
        }
    }
}
