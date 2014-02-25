using System.Collections.Generic;
using Algebra.Core.Type;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Core.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class IfStmnt : IfStmnt<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
		private readonly IType ExpressionType = new BoolType();

		public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            if (!CheckExpression.TypeCheck(data).CompatibleWith(ExpressionType))
            {
                data.ReportError("Unable to evaluate 'if'. Expression must be of type bool!",
                    SourcePosition);
            }

            IfTrueBody.TypeCheck(queue, data);
        }
    }
}
