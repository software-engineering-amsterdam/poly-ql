using System.Collections.Generic;
using Algebra.Core.Type;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class IfElseStmnt : IfElseStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
		private readonly IType ExpressionType = new BoolType();

		public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            if (!CheckExpression.TypeCheck(data).CompatibleWith(ExpressionType))
            {
                data.ReportError("Unable to evaluate 'if/else'. Expression must be of type bool!",
                    SourcePosition);
            }

            IfTrueBody.TypeCheck(queue, data);
            IfFalseBody.TypeCheck(queue, data);
        }
    }
}
