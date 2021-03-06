﻿using System;
using Algebra.QL.Extensions.Environment;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
    public class RepeatStmnt : RepeatStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
        private static readonly ITypeCheckType ExpressionType = new IntType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public RepeatStmnt(ITypeCheckExpr expr, ITypeCheckStmnt body)
            : base(expr, body)
        {

        }

        public void TypeCheck(ITypeEnvironment env)
        {
            if (!Expression.TypeCheck(env).CompatibleWith(ExpressionType))
            {
                env.ReportError("Unable to evaluate 'repeat'. Expression must be an integral type!",
                    SourceStartPosition, SourceEndPosition);
            }

            Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarInstance(0);
            //TODO: Make it so no casting is needed
            ((Environment.TypeEnvironment)env).VarAccess += onVarAccess;

            Body.TypeCheck(env);

            //TODO: Make it so no casting is needed
            ((Environment.TypeEnvironment)env).VarAccess -= onVarAccess;
        }
    }
}
