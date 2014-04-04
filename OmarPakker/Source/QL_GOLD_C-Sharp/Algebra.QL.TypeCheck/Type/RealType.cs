using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;

namespace Algebra.QL.TypeCheck.Type
{
    public class RealType : BaseType
    {
        public override ITypeCheckExpr DefaultValue { get { return new RealLiteral(0); } }
        public override ITypeCheckType SuperType { get { return new BaseType(); } }

        public RealType()
        {

        }

        public override string ToString()
        {
            return "real";
        }
    }
}
