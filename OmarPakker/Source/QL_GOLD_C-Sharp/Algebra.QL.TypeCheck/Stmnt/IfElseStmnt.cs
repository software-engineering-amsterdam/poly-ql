using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class IfElseStmnt : IfElseStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
        private static readonly ITypeCheckType ExpressionType = new BoolType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
        {

        }

        public void TypeCheck(ITypeEnvironment env)
        {
            if (!CheckExpression.TypeCheck(env).CompatibleWith(ExpressionType))
            {
                env.ReportError("Unable to evaluate 'if/else'. Expression must be of type bool!",
                    SourceStartPosition, SourceEndPosition);
            }

            IfTrueBody.TypeCheck(env);
            IfFalseBody.TypeCheck(env);
        }
    }
}
