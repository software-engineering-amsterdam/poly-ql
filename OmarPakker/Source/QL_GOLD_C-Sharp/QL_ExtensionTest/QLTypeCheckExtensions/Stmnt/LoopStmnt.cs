using System;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.QLTypeCheckExtensions.Stmnt
{
	public class LoopStmnt : ITypeCheckStmnt
	{
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
            if (!(Expression.TypeCheck(data) is IntType))
            {
                data.ReportError("Unable to evaluate 'loop'. Expression must be a integral type!",
                    SourcePosition);
            }

            Body.TypeCheck(data);
        }
    }
}
