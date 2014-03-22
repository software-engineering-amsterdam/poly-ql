using System;
using Algebra.Core.Helpers;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Expr
{
    public class SumExpr : Algebra.Core.Expr.VarExpr, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        private static readonly ITypeCheckType ExpressionUpperBound = new RealType();

        public SumExpr(string name)
            : base(name)
        {
            
        }

        public ITypeCheckType TypeCheck(TypeEnvironment env)
        {
            Action<VarAccessEventArgs> onVarAccess = (args) => args.MarkRepeated();
            env.VarAccess += onVarAccess;

            if (!env.IsDeclared(Name))
            {
                env.ReportError(String.Format("Attempting to use 'sum' on a non-existing variable '{0}'." +
                    "'sum' can only be used on variables used in a repeat.",
                    Name), SourceStartPosition, SourceEndPosition);

                return new UnknownType();
            }

            ITypeCheckType type = env.GetDeclared(Name);

            if (!type.CompatibleWith(ExpressionUpperBound))
            {
                env.ReportError(String.Format("Sum not possible. Incompatible type: '{0}'. Only numeric types are supported.",
                    type), SourceStartPosition, SourceEndPosition);

                return ExpressionUpperBound;
            }

            env.VarAccess -= onVarAccess;
            return type;
        }
    }
}
