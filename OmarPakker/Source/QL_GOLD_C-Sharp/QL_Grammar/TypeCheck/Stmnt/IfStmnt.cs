using System;
using System.Collections.Generic;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.TypeCheck.Expr;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class IfStmnt : IfStmntNode<ITypeCheckExpr, ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public IfStmnt(ITypeCheckExpr check, ITypeCheckStmnt ifTrue)
            : base(check, ifTrue)
		{

		}

        public Tuple<int, int> StatementSourcePosition { get; set; }

        public IEnumerable<Tuple<string, bool, int, int>> CheckTypesValid()
        {
            if (!(CheckExpression.ExprType is BoolType))
            {
                yield return new Tuple<string, bool, int, int>(
                    "Unable to evaluate 'if'. Expression must be of type bool!",
                    true, StatementSourcePosition.Item1, StatementSourcePosition.Item2);
            }

            //Flatten errors
            foreach (var error in IfTrueBody.CheckTypesValid())
            {
                yield return error;
            }
        }
    }
}
