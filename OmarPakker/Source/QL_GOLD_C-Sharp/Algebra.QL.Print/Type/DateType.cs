using System;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Print.Type
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
