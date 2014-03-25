using System;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;

namespace Algebra.QL.TypeCheck.Type
{
    public class StringType : BaseType
    {
        public override ITypeCheckExpr DefaultValue { get { return new StringLiteral(String.Empty); } }
        public override ITypeCheckType SuperType { get { return new BaseType(); } }

        public StringType()
        {

        }

        public override string ToString()
        {
            return "string";
        }
    }
}
