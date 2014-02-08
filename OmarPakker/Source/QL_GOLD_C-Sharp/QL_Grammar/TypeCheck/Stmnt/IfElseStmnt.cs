using System;
using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class IfElseStmnt : IfElseStmntNode<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
	{
        public IfElseStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
            : base(check, ifTrue, ifFalse)
		{

		}

        public IEnumerable<Tuple<string, bool>> CheckTypesValid()
        {
            if (!(CheckExpression.ExprType is BoolType))
            {
                yield return new Tuple<string, bool>("Unable to evaluate 'if/else'. Expression must be of type bool!", true);
            }
        }
	}
}
