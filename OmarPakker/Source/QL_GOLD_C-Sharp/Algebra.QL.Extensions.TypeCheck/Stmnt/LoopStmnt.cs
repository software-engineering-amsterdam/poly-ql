using System;
using Algebra.Core.Type;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
	public class LoopStmnt : ITypeCheckStmnt
	{
		private readonly IType ExpressionType = new IntType();
		public Tuple<int, int> SourcePosition { get; set; }
		public ITypeCheckExpr Expression { get; private set; }
		public ITypeCheckStmnt Body { get; private set; }

		public LoopStmnt(ITypeCheckExpr expr, ITypeCheckStmnt body)
		{
			Expression = expr;
			Body = body;
		}

        public void TypeCheck(TypeCheckData data)
        {
			if (!Expression.TypeCheck(data).CompatibleWith(ExpressionType))
            {
                data.ReportError("Unable to evaluate 'loop'. Expression must be a integral type!",
                    SourcePosition);
            }

            Body.TypeCheck(data);
        }
    }
}
