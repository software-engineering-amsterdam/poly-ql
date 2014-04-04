using System;
using Algebra.QL.Extensions.Environment;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Expr
{
    public class AvgExpr : Algebra.Core.Expr.VarExpr, ITypeCheckExpr
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        private static readonly ITypeCheckType ExpressionUpperBound = new RealType();

        public AvgExpr(string name)
            : base(name)
        {
            
        }

        public ITypeCheckType TypeCheck(ITypeEnvironment env)
        {
            Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarInstance(0);
            
            //TODO: Make it so no casting is needed
            ((Environment.TypeEnvironment)env).VarAccess += onVarAccess;

            if (!env.IsDeclared(Name))
            {
                env.ReportError(String.Format("Attempting to use 'avg' on a non-existing variable '{0}'." +
                    "'avg' can only be used on variables used in a repeat.",
                    Name), SourceStartPosition, SourceEndPosition);

                return new UnknownType();
            }

            ITypeCheckType type = env.GetDeclared(Name);

            if (!type.CompatibleWith(ExpressionUpperBound))
            {
                env.ReportError(String.Format("Avg not possible. Incompatible type: '{0}'. Only numeric types are supported.",
                    type), SourceStartPosition, SourceEndPosition);

                return ExpressionUpperBound;
            }

            //TODO: Make it so no casting is needed
            ((Environment.TypeEnvironment)env).VarAccess -= onVarAccess;

            return type;
        }
    }
}
