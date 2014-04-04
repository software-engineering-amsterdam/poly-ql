using System;
using Algebra.QL.Eval.Expr.Literals;
using Algebra.QL.Extensions.Form.Type;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr.Literals
{
    public class DateLiteral : LiteralExpr<DateTime>, IFormExpr
    {
        public DateLiteral(DateTime date)
            : base(date)
        {

        }

        public IFormType BuildForm(ITypeEnvironment env)
        {
            return new DateType();
        }
    }
}
