using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;

namespace Algebra.QL.TypeCheck.Type
{
    public class BoolType : BaseType
	{
        public override ITypeCheckExpr DefaultValue { get { return new BoolLiteral(false); } }
        public override ITypeCheckType SuperType { get { return new BaseType(); } }

        public BoolType()
        {

        }

		public override string ToString()
		{
			return "bool";
		}
	}
}
