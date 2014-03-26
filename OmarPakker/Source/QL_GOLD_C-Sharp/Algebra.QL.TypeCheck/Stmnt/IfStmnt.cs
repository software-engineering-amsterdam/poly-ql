using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
        private static readonly ITypeCheckType ExpressionType = new BoolType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
        {

        }

        public void TypeCheck(TypeEnvironment env)
        {
            if (!CheckExpression.TypeCheck(env).CompatibleWith(ExpressionType))
            {
                env.ReportError("Unable to evaluate 'if'. Expression must be of type bool!",
                    SourceStartPosition, SourceEndPosition);
            }

            IfTrueBody.TypeCheck(env);
        }
    }
}
