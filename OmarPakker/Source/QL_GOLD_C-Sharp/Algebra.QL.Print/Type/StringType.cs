using System;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Print.Type
{
	public class StringType : BaseType
	{
        public override IPrintExpr DefaultValue { get { return new StringLiteral(String.Empty); } }

		public StringType()
		{

		}

		public override string ToString()
		{
			return "string";
		}
	}
}
