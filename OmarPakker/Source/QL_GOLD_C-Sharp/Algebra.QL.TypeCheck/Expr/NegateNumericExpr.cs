using System;
using Algebra.Core.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public class NegateNumericExpr : UnaryExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        private static readonly ITypeCheckType NegationUpperBound = new RealType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public NegateNumericExpr(ITypeCheckExpr e)
            : base(e)
        {

        }

        public ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            ITypeCheckType a = Expr1.TypeCheck(env);

            if (!a.CompatibleWith(NegationUpperBound))
            {
                env.ReportError(String.Format("Negation not possible. Incompatible type: '{0}'. Only numerical types are supported.",
                    a), SourceStartPosition, SourceEndPosition);

                return NegationUpperBound;
            }

            return a;
        }
    }
}
