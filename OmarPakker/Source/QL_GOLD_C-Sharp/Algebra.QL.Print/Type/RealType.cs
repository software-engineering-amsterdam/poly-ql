using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Expr.Literals;

namespace Algebra.QL.Print.Type
{
	public class RealType : BaseType
	{
        public override IPrintExpr DefaultValue { get { return new RealLiteral(0); } }

		public RealType()
		{

		}

		public override string ToString()
		{
			return "real";
		}
	}
}
