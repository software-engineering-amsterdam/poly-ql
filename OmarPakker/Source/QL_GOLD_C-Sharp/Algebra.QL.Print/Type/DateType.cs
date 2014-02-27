using System;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Print.Type
{
	public class DateType : BaseType
	{
        public override Expr.IPrintExpr DefaultValue { get { return new DateLiteral(DateTime.MinValue); } }

		public DateType()
		{

		}

		public override string ToString()
		{
			return "date";
		}
	}
}
