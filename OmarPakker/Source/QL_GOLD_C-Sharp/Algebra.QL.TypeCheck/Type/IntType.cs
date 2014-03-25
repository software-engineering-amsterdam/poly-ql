using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;

namespace Algebra.QL.TypeCheck.Type
{
    public class IntType : BaseType
    {
        public override ITypeCheckExpr DefaultValue { get { return new IntLiteral(0); } }
        public override ITypeCheckType SuperType { get { return new RealType(); } }

        public IntType()
        {

        }

        public override string ToString()
        {
            return "int";
        }
    }
}
