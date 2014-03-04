using System;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
	public class LoopStmnt : LoopStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
		private static readonly ITypeCheckType ExpressionType = new IntType();
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

		public LoopStmnt(ITypeCheckExpr expr, ITypeCheckStmnt body)
            : base(expr, body)
		{

		}

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
			if (!Expression.TypeCheck(env, errRep).CompatibleWith(ExpressionType))
            {
                errRep.ReportError(this, "Unable to evaluate 'loop'. Expression must be an integral type!");
            }

            Body.TypeCheck(env, errRep);
        }
    }
}
