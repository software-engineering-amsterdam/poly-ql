using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class NegateBoolExpr : UnaryExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        private readonly ITypeCheckType NegationUpperBound = new BoolType();

        public NegateBoolExpr(ITypeCheckExpr e)
            : base(e)
        {

        }

        public ITypeCheckType TypeCheck(TypeCheckData data)
        {
            ITypeCheckType a = Expr1.TypeCheck(data);

            if (!a.CompatibleWith(NegationUpperBound))
            {
                data.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only bool types supported.",
                    a), SourcePosition);

                return NegationUpperBound;
            }

            return a;
        }
    }
}
