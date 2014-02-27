using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Print.Type
{
	public class BoolType : BaseType
	{
        public override IPrintExpr DefaultValue { get { return new BoolLiteral(false); } }

		public BoolType()
		{

		}

		public override string ToString()
		{
			return "bool";
		}
	}
}
