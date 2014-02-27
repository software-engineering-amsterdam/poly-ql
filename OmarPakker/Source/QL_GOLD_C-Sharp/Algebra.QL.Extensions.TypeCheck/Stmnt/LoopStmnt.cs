using System.Collections.Generic;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
	public class LoopStmnt : LoopStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
		private readonly ITypeCheckType ExpressionType = new IntType();

		public LoopStmnt(ITypeCheckExpr expr, ITypeCheckStmnt body)
            : base(expr, body)
		{

		}

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
			if (!Expression.TypeCheck(data).CompatibleWith(ExpressionType))
            {
                data.ReportError("Unable to evaluate 'loop'. Expression must be a integral type!",
                    SourcePosition);
            }

            queue.Enqueue(Body);
            if (queue.Count > 0) queue.Dequeue().TypeCheck(queue, data);
        }
    }
}
