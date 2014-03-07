using System;
using Algebra.QL.Extensions.TypeCheck.Expr.Literals;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Type
{
    public class DateType : BaseType
	{
        public override ITypeCheckExpr DefaultValue { get { return new DateLiteral(DateTime.UtcNow.Date); } }
        public override ITypeCheckType SuperType { get { return new BaseType(); } }

        public DateType()
        {

        }

		public override string ToString()
		{
			return "date";
		}
	}
}
