using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class NegateBoolExpr : UnaryExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        private static readonly ITypeCheckType NegationUpperBound = new BoolType();
        public Tuple<int, int> SourcePosition { get; set; }

        public NegateBoolExpr(ITypeCheckExpr e)
            : base(e)
        {

        }

        public ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            ITypeCheckType a = Expr1.TypeCheck(env, errRep);

            if (!a.CompatibleWith(NegationUpperBound))
            {
                errRep.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only bool types supported.",
                    a), SourcePosition);

                return NegationUpperBound;
            }

            return a;
        }
    }
}
