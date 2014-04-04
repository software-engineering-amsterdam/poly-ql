using System;
using Algebra.QL.Extensions.TypeCheck.Type;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, ITypeCheckExpr
    {
        public DateLiteral(DateTime date)
            : base(date)
        {

        }

        public override ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            return new DateType();
        }
    }
}
