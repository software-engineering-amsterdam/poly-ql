using System;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class OrExpr : BinaryExpr, ITypeCheckExpr
    {
        private static readonly ITypeCheckType ExpressionUpperBound = new BoolType();

        public OrExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        public override ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            ITypeCheckType a = Expr1.TypeCheck(env);
            ITypeCheckType b = Expr2.TypeCheck(env);

            if (!a.CompatibleWith(ExpressionUpperBound) || !a.CompatibleWith(b))
            {
                env.ReportError(String.Format("'||' not possible. Incompatible types: '{0}', '{1}'. Only the bool type is supported.",
                    a, b), SourceStartPosition, SourceEndPosition);

                return ExpressionUpperBound;
            }

            return a.GetLeastUpperBound(b);
        }
    }
}
